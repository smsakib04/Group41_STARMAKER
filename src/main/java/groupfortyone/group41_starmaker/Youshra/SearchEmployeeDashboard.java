package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Raghib.Song;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Song.songs;
import static groupfortyone.group41_starmaker.Youshra.Employee.EmployeeList;
import static groupfortyone.group41_starmaker.Youshra.Staff.staffList;

public class SearchEmployeeDashboard {
    @javafx.fxml.FXML
    private TextField EnterTextField;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> EmployeeTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> EmployeeRoleColumn;
    @javafx.fxml.FXML
    private TextField ConfirmationTextField;
    @javafx.fxml.FXML
    private TableView<Employee> EmployeeListTableView;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> EmployeeNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> EmployeeIDColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> DepartmentColumn;

    @javafx.fxml.FXML
    public void initialize() {
        EmployeeTypeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("type"));
        EmployeeRoleColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));
        EmployeeNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        DepartmentColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
        EmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));

        EmployeeListTableView.getItems().addAll(EmployeeList);

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
    public void handleSearchButton(ActionEvent actionEvent) {
        Employee employee = EmployeeListTableView.getSelectionModel().getSelectedItem();
        if (EnterTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name");
            erroralert.show();
            return;
        }
        for (Employee s : EmployeeList) {
            if ((s.getName().equals(EnterTextField.getText()))) {
                EmployeeListTableView.refresh();
                EmployeeListTableView.getItems().addAll(s);

                ConfirmationTextField.setText("Required employee has been shown");
                ConfirmationTextField.setStyle("-fx-background-color: green");
            }
        }
    }
}