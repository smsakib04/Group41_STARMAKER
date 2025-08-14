package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Youshra.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.Employee.EmployeeList;

public class ViewAllEmployeesDashboardController
{
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeNameTV;
    @javafx.fxml.FXML
    private TableView<Employee> allEmployeeTV;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> departmentTV;

    @javafx.fxml.FXML
    public void initialize() {
        employeeNameTV.setCellValueFactory(new PropertyValueFactory<>("name"));
        departmentTV.setCellValueFactory(new PropertyValueFactory<>("department"));

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
    public void viewOA(ActionEvent actionEvent) {
        allEmployeeTV.getItems().addAll(EmployeeList);
    }
}