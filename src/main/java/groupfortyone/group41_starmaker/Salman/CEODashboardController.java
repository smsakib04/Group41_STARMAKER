package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CEODashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void monthlyIncomeReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void scheduleMeeting(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void recruitmentRequisition(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewAllEmployees(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendGlobalMessage(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewUserFeedback(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void totalAppUser(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TotalAppUserDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void assignTasks(ActionEvent actionEvent) {
    }
}