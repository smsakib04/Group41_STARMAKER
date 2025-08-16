package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.Staff.staffList;

public class UpdateStaffRolesDashboard
{
    @javafx.fxml.FXML
    private TextField StaffRoleTextField;
    @javafx.fxml.FXML
    private TableView<Staff> StaffListTableView;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffIDColumn;
    @javafx.fxml.FXML
    private TextField ConfirmationText;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffRolesColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> DepartmentColumn;
    @javafx.fxml.FXML
    private Label SuccessfulLabel;

    @javafx.fxml.FXML
    public void initialize() {StaffNameColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
        StaffIDColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));
        StaffRolesColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("role"));
        DepartmentColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("department"));

        StaffListTableView.getItems().addAll(staffList);

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
        String role = StaffRoleTextField.getText();

        Staff selectedStaff = StaffListTableView.getSelectionModel().getSelectedItem();
        if (selectedStaff==null){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a staff role to edit");
            erroralert.show();
            return;
        }

        if (StaffRoleTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name");
            erroralert.show();
            return;
        }

            ConfirmationText.setText("Staff Role has been updated successfully!");
            ConfirmationText.setStyle("-fx-background-color: green");
        }
        }

