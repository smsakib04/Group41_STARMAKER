package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UploadASongController
{
    @javafx.fxml.FXML
    private Label confirmationlabel;
    @javafx.fxml.FXML
    private ComboBox genrecombobox;
    @javafx.fxml.FXML
    private TextField descriptiontextfield;
    @javafx.fxml.FXML
    private TextField songtitletextfield;
    @javafx.fxml.FXML
    private TableView songlisttableview;
    @javafx.fxml.FXML
    private TableColumn genrecolumn;
    @javafx.fxml.FXML
    private TableColumn descriptioncolumn;
    @javafx.fxml.FXML
    private TableColumn songtitlecolumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void uploadasongOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/SingerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Singer Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}