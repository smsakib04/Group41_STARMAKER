package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CSODashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
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
    public void markQueryAsPriority(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void replyToQuery(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchQuery(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewSolvedQueries(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void deleteASolvedQuery(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void markQueryAsSolved(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateFAQ(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void readQuery(ActionEvent actionEvent) {
    }
}