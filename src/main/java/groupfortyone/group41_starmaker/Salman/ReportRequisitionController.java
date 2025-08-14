package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ReportRequisitionController
{

    @javafx.fxml.FXML
    private TableView reportRequisitionTV;
    @javafx.fxml.FXML
    private TableColumn commentCol;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TableColumn categoryCol;
    @javafx.fxml.FXML
    private TableColumn singerUserNameCol;

    @javafx.fxml.FXML
    public void initialize() {
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

    @Deprecated
    public void viewOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {
    }
}