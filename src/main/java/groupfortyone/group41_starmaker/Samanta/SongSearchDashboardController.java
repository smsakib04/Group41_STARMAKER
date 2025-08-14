package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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


    private ObservableList<Song> allSongsList= FXCollections.observableArrayList();
    private Song selectedSong;

    @javafx.fxml.FXML
    public void initialize() {

        allSongsList.add(new Song("Shape of You", "Pop"));
        allSongsList.add(new Song("Blinding Lights", "Pop"));
        allSongsList.add(new Song("Bohemian Rhapsody", "Rock"));
        allSongsList.add(new Song("Imagine", "Pop"));
        allSongsList.add(new Song("Hotel California", "Rock"));

        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<>("songtitle"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        tableView.setItems(allSongsList);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedSong = (Song) newValue;
        });

    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        String searchQuery = nameofthesongtextfield.getText();

        for (Song song : allSongsList) {
            if (song.getSongtitle().toLowerCase().contains(searchQuery)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Song: " + song.getSongtitle() + "\nGenre: " + song.getGenre(), ButtonType.OK);
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
            // Get the controller of the next scene
            MoreOptionsDashboardController controller = fxmlLoader.getController();

            // Pass the selected song to the next controller
            controller.setSongDetails(selectedSong);
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}