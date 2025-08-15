package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Raghib.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

import static groupfortyone.group41_starmaker.Raghib.Song.songs;

public class SongSearchDashboardController
{
    @javafx.fxml.FXML
    private TableColumn genrecolumn;
    @javafx.fxml.FXML
    private TextField nameofthesongtextfield;
    @javafx.fxml.FXML
    private TableColumn songtitlecolumn;
    @javafx.fxml.FXML
    private TableView tableView;


    //public static ObservableList<SongS> songs= FXCollections.observableArrayList();
    private SongS selectedSongS;
    @javafx.fxml.FXML
    private TableColumn descriptioncolumn;

    @javafx.fxml.FXML
    public void initialize() {
        tableView.getItems().addAll(songs);



        //allSongsList.add(new SongS("Shape of You", "Pop"));
        //allSongsList.add(new SongS("Blinding Lights", "Pop"));
        //allSongsList.add(new SongS("Bohemian Rhapsody", "Rock"));
        // allSongsList.add(new SongS("Imagine", "Pop"));
        // allSongsList.add(new SongS("Hotel California", "Rock"));

        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<groupfortyone.group41_starmaker.Raghib.Song, String>("songtitle"));
        descriptioncolumn.setCellValueFactory(new PropertyValueFactory<groupfortyone.group41_starmaker.Raghib.Song, String>("description"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<groupfortyone.group41_starmaker.Raghib.Song, String>("genre"));


        //tableView.setItems(songs);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedSongS = (SongS) newValue;
        });

    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        String searchQuery = nameofthesongtextfield.getText();

        for (Song songS : songs) {
            if (songS.getSongtitle().toLowerCase().contains(searchQuery)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "SongS: " + songS.getSongtitle() + "\nGenre: " + songS.getGenre(), ButtonType.OK);
                alert.setTitle("SongS Found");
                alert.showAndWait();
                break;
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No songS found matching your search.", ButtonType.OK);
            alert.setTitle("No SongS Found");
            alert.showAndWait();
        }
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
    public void moreOptionsToLikeCommentShareOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/MoreOptionsDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            MoreOptionsDashboardController controller = fxmlLoader.getController();
            controller.setSongDetails(selectedSongS);
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}