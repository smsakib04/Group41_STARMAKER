package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Raghib.Song;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Song.songs;

public class LikeDashboardController
{
    @javafx.fxml.FXML
    private TableColumn<SongS,String> likescolumn;
    @javafx.fxml.FXML
    private TableColumn <SongS,String>genrecolumn;
    @javafx.fxml.FXML
    private TableView<SongS> tableView;
    @javafx.fxml.FXML
    private TableColumn <SongS,String>descriptioncolumn;
    @javafx.fxml.FXML
    private TableColumn<SongS,String> songtitlecolumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/ViewerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void likeOA(ActionEvent actionEvent) {
//        Song songlike= tableView.getSelectionModel().getSelectedItem();
//        songlike.setLikes(true);
//        //countLikes+=1;
    }
}