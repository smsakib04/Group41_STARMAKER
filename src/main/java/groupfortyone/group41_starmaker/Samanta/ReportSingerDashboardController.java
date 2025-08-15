package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ReportSingerDashboardController
{
    @javafx.fxml.FXML
    private ComboBox <String>reportCategoryCB;
    @javafx.fxml.FXML
    private TextField reportSingerUsernameTF;
    @javafx.fxml.FXML
    private TextField reportCommentTF;
    @javafx.fxml.FXML
    private TableColumn<Report, String> singerIDTC;
    @javafx.fxml.FXML
    private TableColumn<Report, String> reportCtgTC;
    @javafx.fxml.FXML
    private TableColumn <Report, String>statusTC;
    @javafx.fxml.FXML
    private TableView<Report> reportTV;
    @javafx.fxml.FXML
    private TableColumn<Report, String> commentTC;
    public static ObservableList<Report> reportList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        reportCategoryCB.getItems().addAll("Harassment", "Bullying", "Fake", "Spam", "Abusive", "Triggering");

        singerIDTC.setCellValueFactory(new PropertyValueFactory<>("singerUsername"));
        reportCtgTC.setCellValueFactory(new PropertyValueFactory<>("reportCategory"));
        commentTC.setCellValueFactory(new PropertyValueFactory<>("comment"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        reportTV.setItems(reportList);

    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/ViewerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void reportbtOA(ActionEvent actionEvent) {
        String singerUsername = reportSingerUsernameTF.getText();
        String reportCategory = reportCategoryCB.getValue();
        String comment = reportCommentTF.getText();


        Report report = new Report(singerUsername, reportCategory, comment, "Pending");
        reportList.add(report);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Report Submitted");
        alert.setHeaderText(null);
        alert.setContentText("The report has been successfully submitted.");
        alert.showAndWait();

    }
}