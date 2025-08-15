package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.Employee.EmployeeList;
import static groupfortyone.group41_starmaker.Youshra.Staff.staffList;

public class ViewStaffListDashboard
{
    @javafx.fxml.FXML
    private TableColumn<Staff,String> DepartmentColumn;
    @javafx.fxml.FXML
    private TableView<Staff> StaffListTableView;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffRoleColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffIDColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffTypeColumn;


    @javafx.fxml.FXML
    public void initialize() {
        StaffNameColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
        StaffIDColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));
        StaffRoleColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("role"));
        DepartmentColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("department"));
        StaffTypeColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("type"));
    }

    @javafx.fxml.FXML
    public void handleViewButton(ActionEvent actionEvent) {
        if (EmployeeList.isEmpty()) {
        Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
        erroralert.setContentText("There are no songs to show");
        erroralert.show();
        return;
    }
        StaffListTableView.getItems().clear();
        StaffListTableView.getItems().addAll(staffList);
    }

    @javafx.fxml.FXML
    public void handlePreviousbutton(ActionEvent actionEvent) {
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
}