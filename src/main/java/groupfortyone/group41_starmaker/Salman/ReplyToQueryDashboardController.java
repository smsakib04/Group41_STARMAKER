package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ReplyToQueryDashboardController
{
    @javafx.fxml.FXML
    private TableColumn queryNoCol;
    @javafx.fxml.FXML
    private TableView replyQueryTV;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TextArea replyTA;
    @javafx.fxml.FXML
    private TableColumn queryCol;
    @javafx.fxml.FXML
    private TableColumn nameCol;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void sendOA(ActionEvent actionEvent) {
    }
}