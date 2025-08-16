package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MessageFollowerDashboardController
{

    @javafx.fxml.FXML
    private TableView <Message>messageTV;
    @javafx.fxml.FXML
    private TableColumn   messageToTC;
    @javafx.fxml.FXML
    private TableColumn messageBodyTC;
    @javafx.fxml.FXML
    private TextField messageBodyTF;
    private String followerName;


    @javafx.fxml.FXML
    public void initialize() {
        messageToTC.setCellValueFactory(new PropertyValueFactory<>("to"));
        messageBodyTC.setCellValueFactory(new PropertyValueFactory<>("messageContent"));
    }

    @javafx.fxml.FXML
    public void messageSendOA(ActionEvent actionEvent) {
        if (followerName != null ) {
            String message = messageBodyTF.getText();

            // Create a Message object with the follower's name and the message content
            Message newMessage = new Message("null because the from row doesnt exist", followerName, message);

            // Add the Message object to the TableView
            messageTV.getItems().add(newMessage);

            // Clear the message body text field
            messageBodyTF.clear();
        } else {
            // Show an alert if no message is entered
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please write a message before sending.", ButtonType.OK);
            alert.setTitle("Message Error");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/LiveBroadcasterDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setfollowerName(Follower selectedfollower) {
        this.followerName = selectedfollower.getFollowerName();

    }
}