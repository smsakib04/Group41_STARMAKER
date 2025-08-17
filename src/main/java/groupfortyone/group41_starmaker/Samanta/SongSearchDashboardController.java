package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Raghib.Song;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import static groupfortyone.group41_starmaker.Raghib.Song.songs;

public class SongSearchDashboardController {
    @javafx.fxml.FXML
    private TableColumn<Song, String> genrecolumn;
    @javafx.fxml.FXML
    private TextField nameofthesongtextfield;
    @javafx.fxml.FXML
    private TableColumn<Song, String> songtitlecolumn;
    @javafx.fxml.FXML
    private TableView<Song> tableView;
    @javafx.fxml.FXML
    private TableColumn<Song, String> descriptioncolumn;

    @javafx.fxml.FXML
    public void initialize() {
        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<groupfortyone.group41_starmaker.Raghib.Song, String>("songtitle"));
        descriptioncolumn.setCellValueFactory(new PropertyValueFactory<groupfortyone.group41_starmaker.Raghib.Song, String>("description"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<groupfortyone.group41_starmaker.Raghib.Song, String>("genre"));

        tableView.getItems().addAll(songs);

    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        String searchQuery = nameofthesongtextfield.getText();

        for (Song songS : songs) {
            if (songS.getSongtitle().toLowerCase().contains(searchQuery)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Song: " + songS.getSongtitle() + "\nGenre: " + songS.getGenre(), ButtonType.OK);
                alert.setTitle("Song Found");
                alert.showAndWait();
                break;
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No song found matching your search.", ButtonType.OK);
            alert.setTitle("No Song Found");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/ViewerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @javafx.fxml.FXML
    public void commentOA(ActionEvent actionEvent) {
        Song selectedSong= tableView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/CommentDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                CommentDashboardController controller = fxmlLoader.getController();
                controller.setSongDetails(selectedSong);
                Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    @javafx.fxml.FXML
    public void repostDbOA(ActionEvent actionEvent) {
        Song selectedSong= tableView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/RepostSongDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                RepostSongDashboardController controller = fxmlLoader.getController();
                controller.setSongDetails(selectedSong);
                Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}