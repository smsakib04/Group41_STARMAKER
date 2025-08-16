package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

import static groupfortyone.group41_starmaker.Raghib.Campaign.campaignupdatesList;
import static groupfortyone.group41_starmaker.Raghib.Song.songs;

public class SendCampaignUpdatesToTeamMembers
{
    @javafx.fxml.FXML
    private ListView campaignnoteslistview;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TextField sendcampaignupdatestextfield;

    @javafx.fxml.FXML
    public void initialize() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("campaignupdatesinfo.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);

            } else {
                Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("Bin File does not exist.");
                erroralert.show();
            }
            if (fis != null) {
                ois = new ObjectInputStream(fis);
            }
            while (true) {
                campaignnoteslistview.getItems().add((Campaign) ois.readObject());
            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {
            }
        }
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/MarketingExecutiveOfficerDashboard.fxml"));

            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Marketing Executive Officer Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void addcampaignnotesOnAction(ActionEvent actionEvent) {
        String q=sendcampaignupdatestextfield.getText();
        if (q.isEmpty()){
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Give some updates");
            erroralert.show();
            return;
        }
        campaignupdatesList.add(q);
        campaignnoteslistview.getItems().addAll(q);
        confirmationtextarea.setText("Updates have been sent successfully");
        confirmationtextarea.setStyle("-fx-background-color: green");
        sendcampaignupdatestextfield.clear();

        try {
            File f = new File("campaignupdatesinfo.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            }
            for (String g : campaignupdatesList) {
                oos.writeObject(g);
            }
            oos.close();
        } catch (Exception e) {
        }
    }
}