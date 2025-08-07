package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AssignTaskDashboardController
{
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TextArea assignTaskTA;
    @javafx.fxml.FXML
    private ComboBox selectEmployeeCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void csoTaskOA(ActionEvent actionEvent) {
    }

    @Deprecated
    public void hrmTaskOA(ActionEvent actionEvent) {
    }

    @Deprecated
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

    @Deprecated
    public void acountantTaskOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendOA(ActionEvent actionEvent) {
    }
}