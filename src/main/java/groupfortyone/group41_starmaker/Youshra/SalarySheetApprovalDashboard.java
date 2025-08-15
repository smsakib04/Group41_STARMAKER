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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.Salary.salaryList;
import static groupfortyone.group41_starmaker.Youshra.Staff.staffList;

public class SalarySheetApprovalDashboard
{
    @javafx.fxml.FXML
    private TableColumn<Salary,String> EmployeeRoleColumn;
    @javafx.fxml.FXML
    private TableColumn<Salary,String> SalaryColumn;
    @javafx.fxml.FXML
    private TableColumn<Salary,String> EmployeeNameColumn;
    @javafx.fxml.FXML
    private TableView<Salary> SalarySheetTableView;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;

    @javafx.fxml.FXML
    public void initialize() {
        EmployeeRoleColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("role"));
        EmployeeNameColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("name"));
        SalaryColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("salary"));

        SalarySheetTableView.getItems().addAll(salaryList);
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
    public void handleSentToCEObutton(ActionEvent actionEvent) {
        SuccessfulTextField.setText("Request Sent successfully!");
        SuccessfulTextField.setStyle("-fx-background-color: white");
    }
}