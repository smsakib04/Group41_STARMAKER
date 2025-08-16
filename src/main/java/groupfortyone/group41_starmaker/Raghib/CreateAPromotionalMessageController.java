package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

import static groupfortyone.group41_starmaker.Raghib.Campaign.campaignupdatesList;
import static groupfortyone.group41_starmaker.Raghib.Message.messageList;

public class CreateAPromotionalMessageController
{
    @javafx.fxml.FXML
    private TextArea messagecontenttextarea;
    @javafx.fxml.FXML
    private TextField usernametextfield;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;

    @javafx.fxml.FXML
    public void initialize() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("promotionalmessageinfo.bin");
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
                messageList.add((Message) ois.readObject());
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
    public void saveOnAction(ActionEvent actionEvent) {
        Message m=new Message(usernametextfield.getText(),messagecontenttextarea.getText());
        if ((usernametextfield.getText().isEmpty()) && (messagecontenttextarea.getText().isEmpty())){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a valid username and content");
            erroralert.show();
            return;
        }
        if(usernametextfield.getText().isEmpty()){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a valid username");
            erroralert.show();
            return;
        }
        if(messagecontenttextarea.getText().isEmpty()){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a message");
            erroralert.show();
            return;

        }
        messageList.add(m);
        confirmationtextarea.setText("Message has been added successfully!");
        confirmationtextarea.setStyle("-fx-background-color: green");

        try {
            File f = new File("promotionalmessageinfo.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            }
            for (Message a : messageList) {
                oos.writeObject(a);
            }
            oos.close();
        } catch (Exception e) {
        }
    }

}