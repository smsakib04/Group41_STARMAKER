package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Raghib.Song;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Song.songs;

public class LikeDashboardController
{
    @javafx.fxml.FXML
    private TableColumn likescolumn;
    @javafx.fxml.FXML
    private TableColumn genrecolumn;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn descriptioncolumn;
    @javafx.fxml.FXML
    private TableColumn songtitlecolumn;

    @javafx.fxml.FXML
    public void initialize() {
        tableView.getItems().addAll(songs);


        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("songtitle"));
        descriptioncolumn.setCellValueFactory(new PropertyValueFactory<groupfortyone.group41_starmaker.Raghib.Song, String>("description"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<groupfortyone.group41_starmaker.Raghib.Song, String>("genre"));
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
    }
}