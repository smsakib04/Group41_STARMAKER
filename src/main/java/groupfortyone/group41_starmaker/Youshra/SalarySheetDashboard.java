package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.Expense.expense;
import static groupfortyone.group41_starmaker.Youshra.Salary.salaryList;

public class SalarySheetDashboard
{
    @javafx.fxml.FXML
    private TableColumn<Salary,String> EmployeeRoleColumn;
    @javafx.fxml.FXML
    private TextField EmployeeRoleTextField;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;
    @javafx.fxml.FXML
    private TextField EmployeeNameTextFielld;
    @javafx.fxml.FXML
    private TextField SalaryTextField;
    @javafx.fxml.FXML
    private TableColumn<Salary,String> SalaryColumn;
    @javafx.fxml.FXML
    private TableView<Salary> SalarySheetTableView;
    @javafx.fxml.FXML
    private TableColumn<Salary,String> EmployeeNameColumn;

    @javafx.fxml.FXML
    public void initialize() {
        EmployeeRoleColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("role"));
        EmployeeNameColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("name"));
        SalaryColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("salary"));
    }

    @javafx.fxml.FXML
    public void handleAddbutton(ActionEvent actionEvent) {
        if (EmployeeNameTextFielld.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name!");
            erroralert.show();
            return;
        }
        if (EmployeeRoleTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a role!");
            erroralert.show();
            return;
        }
        if (SalaryTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide salary!");
            erroralert.show();
            return;
        }

        Salary a = new Salary(EmployeeNameTextFielld.getText(),EmployeeRoleTextField.getText(),SalaryTextField.getText());
        salaryList.add(a);
        SalarySheetTableView.getItems().add(a);

        SuccessfulTextField.setText("Staff has been added successfully!");
        SuccessfulTextField.setStyle("-fx-background-color:green");

        EmployeeRoleTextField.clear();
        EmployeeNameTextFielld.clear();
        SalaryTextField.clear();
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
}