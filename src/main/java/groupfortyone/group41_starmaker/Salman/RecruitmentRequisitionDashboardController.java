package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class RecruitmentRequisitionDashboardController
{
    @javafx.fxml.FXML
    private Label recruitmentAcceptanceLabel;
    @javafx.fxml.FXML
    private TableView recruitmentRequisitionTV;
    @javafx.fxml.FXML
    private Label recruitmentRejectedLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void confirmOA(ActionEvent actionEvent) {
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
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {
    }
}