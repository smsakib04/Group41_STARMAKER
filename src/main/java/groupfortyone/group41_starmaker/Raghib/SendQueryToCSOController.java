package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SendQueryToCSOController
{
    @javafx.fxml.FXML
    private AnchorPane querytextarea;
    @javafx.fxml.FXML
    private Label confirmationlabel;
    @javafx.fxml.FXML
    private TextField usernametextfield;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/SingerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Singer Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void sendOnAction(ActionEvent actionEvent) {
    }
}