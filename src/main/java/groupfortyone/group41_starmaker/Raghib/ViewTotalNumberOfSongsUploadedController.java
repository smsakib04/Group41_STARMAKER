package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Song.songs;
public class ViewTotalNumberOfSongsUploadedController
{
    @javafx.fxml.FXML
    private TableView<Song> songlisttableview;
    @javafx.fxml.FXML
    private TableColumn<Song,String> genrecolumn;
    @javafx.fxml.FXML
    private TableColumn<Song,String> descriptioncolumn;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TableColumn<Song,String> songtitlecolumn;

    @javafx.fxml.FXML
    public void initialize() {
        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("songtitle"));
        descriptioncolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("description"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("genre"));
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
    public void viewallsongsOnAction(ActionEvent actionEvent) {
        songlisttableview.getItems().clear();
        songlisttableview.getItems().addAll(songs);
        confirmationtextarea.setText("All songs are shown above");
        confirmationtextarea.setStyle("-fx-background-color: green");
    }
}