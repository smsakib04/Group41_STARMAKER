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


public class AddNewStaffDashboardController
{
    @javafx.fxml.FXML
    private TextField DepartmentTextField;
    @javafx.fxml.FXML
    private TableView<Staff> StaffListTableView;
    @javafx.fxml.FXML
    private Label SuccessfulLabel;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffRoleColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffNameColumn;
    @javafx.fxml.FXML
    private TextField StaffIDTextField;
    @javafx.fxml.FXML
    private TextField StaffRoleTextField;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffIDColumn;
    @javafx.fxml.FXML
    private TextField StaffNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> DepartmentColumn;

    @javafx.fxml.FXML
    public void initialize() {
        StaffNameColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
        StaffIDColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));
        StaffRoleColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("role"));
        DepartmentColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("department"));
    }

    @javafx.fxml.FXML
    public void handleAddbutton(ActionEvent actionEvent) {
        if (StaffNameTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name");
            erroralert.show();
            return;
        }
        if (StaffIDTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a staff ID");
            erroralert.show();
            return;
        }
        if (StaffRoleTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide name of staff role");
            erroralert.show();
            return;
        }
        if (DepartmentTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide department of staff");
            erroralert.show();
            return;
        }
        int id;
        try{
            id = Integer.parseInt(StaffIDTextField.getText());
        } catch (NumberFormatException e) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Enter an integer number");
            erroralert.show();
            return;
        }
        for (Staff s:staffList){
            if (s.getName().equals(StaffNameTextField.getText())){
                Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("Provide a unique name");
                erroralert.show();
                return;
            }

        }
        Staff s=new Staff(
                StaffNameTextField.getText(),
                Integer.parseInt(StaffIDTextField.getText()),
                DepartmentTextField.getText(),
                StaffRoleTextField.getText());

        staffList.add(s);
        StaffListTableView.getItems().addAll(s);
        SuccessfulLabel.setText("Staff has been added successfully!");
        SuccessfulLabel.setStyle("-fx-background-color: white");

        StaffNameTextField.clear();
        StaffRoleTextField.clear();
        StaffIDTextField.clear();
        DepartmentTextField.clear();
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
}