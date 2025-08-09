package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Message.messageList;

public class CreateAPromotionalMessageController
{
    @javafx.fxml.FXML
    private Label confirmationmessagelabel;
    @javafx.fxml.FXML
    private TextArea messagecontenttextarea;
    @javafx.fxml.FXML
    private TextField usernametextfield;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/MarketingExecutiveDashboard.fxml"));

            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Marketing Executive Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {
        if(usernametextfield.getText().isEmpty()){
            confirmationmessagelabel.setText("Enter a valid username!");
            return;
        }
        if(messagecontenttextarea.getText().isEmpty()){
            confirmationmessagelabel.setText("Give a valid promotional message!");
            return;

        }
        messageList.add(usernametextfield.getText());
        messageList.add(messagecontenttextarea.getText());
        confirmationmessagelabel.setText("Message has been added successfully!");
    }
}