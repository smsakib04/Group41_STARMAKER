package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AssignTaskDashboardController
{
    @javafx.fxml.FXML
    private TextField csoTaskTF;
    @javafx.fxml.FXML
    private TextField hrmTaskTF;
    @javafx.fxml.FXML
    private TextField accountantTaskTF;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TextField marketingExecutiveTaskTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void csoTaskOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void hrmTaskOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void marketingExecutiveOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Salman/CEO_Dashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void acountantTaskOA(ActionEvent actionEvent) {
    }
}