package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SalarySheetDashboard
{
    @javafx.fxml.FXML
    private TableColumn EmployeeRoleColumn;
    @javafx.fxml.FXML
    private TextField EmployeeRoleTextField;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;
    @javafx.fxml.FXML
    private Label SuccessfulLabel;
    @javafx.fxml.FXML
    private TextField EmployeeNameTextFielld;
    @javafx.fxml.FXML
    private TextField SalaryTextField;
    @javafx.fxml.FXML
    private TableColumn SalaryColumn;
    @javafx.fxml.FXML
    private TableColumn EmplyeeNameColumn;
    @javafx.fxml.FXML
    private TableView SalarySheetTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleAddbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlePreviousPagebutton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/AccountantDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void handleCreateSalarySheetButton(ActionEvent actionEvent) {
    }
}