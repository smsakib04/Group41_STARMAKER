package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class /RefundRequestDashboard
{
    @javafx.fxml.FXML
    private TableColumn RefundTypeColumn;
    @javafx.fxml.FXML
    private TableView RequestTableView;
    @javafx.fxml.FXML
    private TableColumn UsernameColumn;
    @javafx.fxml.FXML
    private TableColumn AmountColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleViewButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlePreviousButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/AccountantDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void handleAcceptButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDeclineButton(ActionEvent actionEvent) {
    }

}