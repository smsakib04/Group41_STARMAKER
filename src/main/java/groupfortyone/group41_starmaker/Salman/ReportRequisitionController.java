package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Samanta.Report;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Samanta.ReportSingerDashboardController.reportList;

public class ReportRequisitionController
{

    @javafx.fxml.FXML
    private TableView<Report> reportRequisitionTV;
    @javafx.fxml.FXML
    private TableColumn<Report, String> commentCol;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TableColumn<Report, String> categoryCol;
    @javafx.fxml.FXML
    private TableColumn<Report, String> singerUserNameCol;

    @javafx.fxml.FXML
    public void initialize() {
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("reportCategory"));
        singerUserNameCol.setCellValueFactory(new PropertyValueFactory<>("singerUsername"));

        for (Report x : reportList){
            if (x.getStatus().equals("Pending")){
                reportRequisitionTV.getItems().add(x);
            }
        }
    }

    @Deprecated
    public void markAsPriorityOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Salman/CSO_Dashboard.fxml"));
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
        Report r = reportRequisitionTV.getSelectionModel().getSelectedItem();
        if (r == null) {
            return;

        }
        r.setStatus("Approved");
        reportRequisitionTV.getItems().clear();

        for (Report x : reportList){
            if (x.getStatus().equals("Pending")){
                reportRequisitionTV.getItems().add(x);
            }
        }
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {
        Report r = reportRequisitionTV.getSelectionModel().getSelectedItem();
        if (r == null) {
            return;

        }
        r.setStatus("Rejected");
        reportRequisitionTV.getItems().clear();

        for (Report x : reportList){
            if (x.getStatus().equals("Pending")){
                reportRequisitionTV.getItems().add(x);
            }
        }

    }
}