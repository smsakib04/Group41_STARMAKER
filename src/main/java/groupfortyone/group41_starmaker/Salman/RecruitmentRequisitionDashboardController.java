package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Youshra.Employee;
import groupfortyone.group41_starmaker.Youshra.EmployeeApproval;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

import static groupfortyone.group41_starmaker.Youshra.Employee.EmployeeList;
import static groupfortyone.group41_starmaker.Youshra.EmployeeApproval.employee;

public class RecruitmentRequisitionDashboardController
{
    @javafx.fxml.FXML
    private TableView<Employee> recruitmentRequisitionTV;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> roleCol;

    private ArrayList<Employee> approvedList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));

        recruitmentRequisitionTV.getItems().addAll(EmployeeList);

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
    public void approveOA(ActionEvent actionEvent) {
        Employee approvals = (Employee) recruitmentRequisitionTV.getSelectionModel().getSelectedItem();
        approvedList.add(approvals);
        employee.remove(approvals);
        recruitmentRequisitionTV.getItems().clear();
        recruitmentRequisitionTV.getItems().addAll(EmployeeList);
        confirmationMessageLabel.setText("Requisition Accepted!");
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {
        Employee approvals = recruitmentRequisitionTV.getSelectionModel().getSelectedItem();
        employee.remove(approvals);
        recruitmentRequisitionTV.getItems().clear();
        recruitmentRequisitionTV.getItems().addAll(EmployeeList);
        confirmationMessageLabel.setText("Requistion Rejected!");
    }
}