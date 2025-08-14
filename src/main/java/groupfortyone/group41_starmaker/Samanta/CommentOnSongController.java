package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CommentOnSongController
{
    @javafx.fxml.FXML
    private TextField commentTF;
    @javafx.fxml.FXML
    private TableColumn songTitleTC;
    @javafx.fxml.FXML
    private TableView commentTV;
    @javafx.fxml.FXML
    private TextField yourNameTF;
    @javafx.fxml.FXML
    private TableColumn yourNameTC;
    @javafx.fxml.FXML
    private TableColumn genreTC;
    @javafx.fxml.FXML
    private TableColumn dateTC;
    @javafx.fxml.FXML
    private TableColumn commentTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendCommentOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/MoreOptionsDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}