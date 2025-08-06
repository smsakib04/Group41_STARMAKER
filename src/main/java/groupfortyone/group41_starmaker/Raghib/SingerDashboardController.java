package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SingerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void deleteasongOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(".fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle(" Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void searchasongbytitleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewtotalnooflikesofasongOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void uploadasongOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewtotalnumberofsongsuploadedOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void markasongasfavouriteOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void editsongtitleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void myprofileOnAction(ActionEvent actionEvent) {
    }
}