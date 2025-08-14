package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeeRolesDashboard
{
    @javafx.fxml.FXML
    private TextField EmployeeRoleTextField;
    @javafx.fxml.FXML
    private Label SuccessfulLabel;
    @javafx.fxml.FXML
    private TextField EmployeeIDTextField;
    @javafx.fxml.FXML
    private TextField EmployeeNameTextField;
    @javafx.fxml.FXML
    private ComboBox DepartmentComboBox;
    @javafx.fxml.FXML
    private ComboBox EmployeetYpeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
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

    @javafx.fxml.FXML
    public void handleAssignButton(ActionEvent actionEvent) {
    }
}