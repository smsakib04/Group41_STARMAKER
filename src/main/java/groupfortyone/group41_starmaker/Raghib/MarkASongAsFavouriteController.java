package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Song.favSongs;
import static groupfortyone.group41_starmaker.Raghib.Song.songs;


public class MarkASongAsFavouriteController
{
    @javafx.fxml.FXML
    private TableView<Song> songlisttableview;
    @javafx.fxml.FXML
    private TableColumn<Song,String> genrecolumn;
    @javafx.fxml.FXML
    private TableColumn<Song,String> descriptioncolumn;
    @javafx.fxml.FXML
    private TableColumn<Song,String> songtitlecolumn;
    @javafx.fxml.FXML
    private TableColumn<Song,String> descriptioncolumn2;
    @javafx.fxml.FXML
    private TableView<Song> songlisttableview2;
    @javafx.fxml.FXML
    private TableColumn<Song,String> genrecolumn2;
    @javafx.fxml.FXML
    private TableColumn<Song,String> songtitlecolumn2;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;

    @javafx.fxml.FXML
    public void initialize() {
        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("songtitle"));
        descriptioncolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("description"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("genre"));

        songlisttableview.getItems().addAll(songs);

        songtitlecolumn2.setCellValueFactory(new PropertyValueFactory<Song, String>("songtitle"));
        descriptioncolumn2.setCellValueFactory(new PropertyValueFactory<Song, String>("description"));
        genrecolumn2.setCellValueFactory(new PropertyValueFactory<Song, String>("genre"));
        songlisttableview2.getItems().addAll(favSongs);
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

    @javafx.fxml.FXML
    public void markasfavouriteOnAction(ActionEvent actionEvent) {
        Song song= songlisttableview.getSelectionModel().getSelectedItem();
        if (song==null){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a song");
            erroralert.show();
            return;
        }
        for (Song s : favSongs) {
            if (s == song) {
                Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("Song is already in the fav list");
                erroralert.show();
                return;
            }
        }
        favSongs.add(song);
        songlisttableview.refresh();
        songlisttableview2.getItems().clear();
        songlisttableview2.getItems().addAll(favSongs);
        confirmationtextarea.setText("Song has been marked as favourite");
        confirmationtextarea.setStyle("-fx-background-color: Green");
    }
}