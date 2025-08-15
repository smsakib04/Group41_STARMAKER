package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RecruitmentRequestDashboard {
    @javafx.fxml.FXML
    private TextField EmployeeRoleTextField;
    @javafx.fxml.FXML
    private Label RequestSentLabel;
    @javafx.fxml.FXML
    private TextField EmployeeNameTextField;
    @javafx.fxml.FXML
    private ComboBox DepartmentComboBox;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;
    @javafx.fxml.FXML
    private ComboBox EmployeeTypeComboBox;

    public static ArrayList<Employee> EmployeeList = new ArrayList<Employee>();

    @javafx.fxml.FXML
    public void initialize() {
        DepartmentComboBox.getItems().addAll("Accounts", "Customer Care");
        EmployeeTypeComboBox.getItems().addAll("Intern", "Junior", "Senior");
    }

    @javafx.fxml.FXML
    public void handlePreviousButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/HumanResourceManagerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void handleSendRequestButton(ActionEvent actionEvent) {

        String name = EmployeeNameTextField.getText();
        String id = EmployeeRoleTextField.getText();

        if (EmployeeNameTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name");
            erroralert.show();
            return;

        }
        if (EmployeeRoleTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name");
            erroralert.show();
            return;

        }
        SuccessfulTextField.setText("Request Sent successfully!");
        SuccessfulTextField.setStyle("-fx-background-color: white");


    }
}