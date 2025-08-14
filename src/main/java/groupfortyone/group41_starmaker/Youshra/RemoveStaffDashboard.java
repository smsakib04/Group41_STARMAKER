package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.Staff.staffList;

public class RemoveStaffDashboard
{
    @javafx.fxml.FXML
    private TableView<Staff> StaffListTableView;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffIDColumn;
    @javafx.fxml.FXML
    private TextField ConfirmationTextField;

    @javafx.fxml.FXML
    public void initialize() {
        StaffNameColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
        StaffIDColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));


        StaffListTableView.getItems().addAll(staffList);
    }

    @javafx.fxml.FXML
    public void handleRemovebutton(ActionEvent actionEvent) {
        Staff staff= StaffListTableView.getSelectionModel().getSelectedItem();
        if (staff==null){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a staff");
            erroralert.show();
            return;
        }
        staffList.remove(staff);
        StaffListTableView.getItems().clear();
        StaffListTableView.getItems().addAll(staffList);
        ConfirmationTextField.setText("Staff has been removed");

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
