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

import java.time.LocalDate;

public class CommentDashboardController
{
    private Song currentSongS;
    @javafx.fxml.FXML
    private TextField commentTF;
    @javafx.fxml.FXML
    private TableView commentTV;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TableColumn dateTC;
    @javafx.fxml.FXML
    private TableColumn commentTC;
    private ObservableList<Comment> commentsList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        titleTC.setCellValueFactory(new PropertyValueFactory<>("songName"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("commentDate"));
        commentTC.setCellValueFactory(new PropertyValueFactory<>("commentText"));

        commentTV.setItems(commentsList);
    }


    @javafx.fxml.FXML
    public void commentOA(ActionEvent actionEvent) {
        String commentText = commentTF.getText();
        if (currentSongS != null && !commentText.isEmpty()) {
            Comment newComment = new Comment(commentText, currentSongS.getSongtitle(), LocalDate.now());
            commentsList.add(newComment);
            commentTF.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please Select a Song.", ButtonType.OK);
            alert.setTitle("No Comment Entered");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/SongSearchDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void setSongDetails(Song selectedSong) {
        this.currentSongS = selectedSong;
    }
}