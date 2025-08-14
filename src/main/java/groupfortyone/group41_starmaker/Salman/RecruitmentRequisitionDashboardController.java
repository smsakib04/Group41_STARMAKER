package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
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

public class RecruitmentRequisitionDashboardController
{
    @javafx.fxml.FXML
    private TableView recruitmentRequisitionTV;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TableColumn employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn employeeDOBCol;
    @javafx.fxml.FXML
    private TableColumn employeeEducationCol;

//    private ArrayList<Requisition> approvedList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>(""));
        employeeDOBCol.setCellValueFactory(new PropertyValueFactory<>(""));
        employeeEducationCol.setCellValueFactory(new PropertyValueFactory<>(""));
        recruitmentRequisitionTV.getItems().addAll();

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
//        Requisition approvals = recruitmentRequisitionTV.getSelectionModel().getSelectedItem();
//        approvedList.add(approvals);
//        approvalList.remove(approvals);
//        recruitmentRequisitionTV.getItems().clear();
//        recruitmentRequisitionTV.getItems().addAll();
//        confirmationMessageLabel.setText("Requisition Accepted!");
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {
//        Requisition approvals = recruitmentRequisitionTV.getSelectionModel().getSelectedItem();
//        approvalList.remove(approvals);
//        recruitmentRequisitionTV.getItems().clear();
//        recruitmentRequisitionTV.getItems().addAll(approvalList);
//        confirmationMessageLabel.setText("Requistion Rejected!");
    }
}