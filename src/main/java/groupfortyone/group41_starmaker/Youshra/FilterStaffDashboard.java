package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

import static groupfortyone.group41_starmaker.Youshra.Staff.staffList;

public class FilterStaffDashboard
{
    @javafx.fxml.FXML
    private TableColumn<Staff,String> DepartmentColumn;
    @javafx.fxml.FXML
    private TableView<Staff> StaffListTableView;
    @javafx.fxml.FXML
    private TextField StaffIDTextField1;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffRoleColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> StaffIDColumn;
    @javafx.fxml.FXML
    private TextField StaffNameTextField;
    @javafx.fxml.FXML
    private TextField confirmationtextfield;

    @javafx.fxml.FXML
    public void initialize() {
        StaffNameColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
        StaffIDColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));
        StaffRoleColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("role"));
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
    public void handleSearchButton(ActionEvent actionEvent) {
        StaffListTableView.getItems().clear();

        if (StaffNameTextField.getText().isEmpty()){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name");
            erroralert.show();
            return;
        }
        if (StaffIDTextField1.getText().isEmpty()){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide an id");
            erroralert.show();
            return;

        }

        for (Staff s:staffList){
            if((s.getName().equals(StaffNameTextField.getText()) && (s.getId()==(Integer.parseInt(StaffIDTextField1.getText()))))){
                StaffListTableView.refresh();
                StaffListTableView.getItems().addAll(s);

            }
        }
        confirmationtextfield.setText("Staff has been added successfully!");
        confirmationtextfield.setStyle("-fx-background-color: white");



    }
}