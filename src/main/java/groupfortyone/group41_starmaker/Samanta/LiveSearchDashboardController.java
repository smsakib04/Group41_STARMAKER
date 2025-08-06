package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LiveSearchDashboardController
{
    @javafx.fxml.FXML
    private TextField nameoftheLiveTF;
    @javafx.fxml.FXML
    private TableColumn livedateTC;
    @javafx.fxml.FXML
    private TableColumn livetitleTC;
    @javafx.fxml.FXML
    private TableColumn descriptionTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void nameoftheLiveOA(ActionEvent actionEvent) {
    }

    @Deprecated
    public void gobackOA(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void searchOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/LiveBroadcasterDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}