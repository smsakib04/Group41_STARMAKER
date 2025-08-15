package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AnnouncementDashboard
{
    @javafx.fxml.FXML
    private TextField AnnouncementTextField;
    @javafx.fxml.FXML
    private Label SentLabel;
    @javafx.fxml.FXML
    private TextArea ConfirmationTextArea;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void handleSendButton(ActionEvent actionEvent) {
        String announcement = AnnouncementTextField.getText();

        if (AnnouncementTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide an announcement");
            erroralert.show();
            return;

            ConfirmationTextArea.setText("Sent successfully!");
            ConfirmationTextArea.setStyle("-fx-background-color:green");
    }

    @javafx.fxml.FXML
    public void handlePreviousButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/HumanResourceManagerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
}