package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

import static groupfortyone.group41_starmaker.Raghib.Campaign.campaignList;
import static groupfortyone.group41_starmaker.Raghib.Song.songs;

public class DeleteACampaignPostController
{
    @javafx.fxml.FXML
    private TableView<Campaign> campaignlisttableview;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> contentcolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> poststatuscolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> datecolumn;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> titlecolumn;

    @javafx.fxml.FXML
    public void initialize() {
        titlecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("title"));
        contentcolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("content"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("date"));
        poststatuscolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("status"));

        campaignlisttableview.getItems().addAll(campaignList);


        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("deletecampaigninfo.bin");
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
                campaignlisttableview.getItems().add((Campaign) ois.readObject());
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
    public void deleteOnAction(ActionEvent actionEvent) {
        Campaign campaign=campaignlisttableview.getSelectionModel().getSelectedItem();
        if (campaign==null){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a campaign post");
            erroralert.show();
            return;
        }
        campaignList.remove(campaign);
        campaignlisttableview.getItems().clear();
        campaignlisttableview.getItems().addAll(campaignList);
        confirmationtextarea.setText("Campaign post has been removed");
        confirmationtextarea.setStyle("-fx-background-color: green");


        try (FileOutputStream fos = new FileOutputStream("deletecampaigninfo.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Campaign i : campaignList) {
                oos.writeObject(i);
            }

        } catch (Exception e) {
        }
    }
}