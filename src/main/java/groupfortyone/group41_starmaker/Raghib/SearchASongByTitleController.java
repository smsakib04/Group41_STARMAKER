package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Song.songs;

public class SearchASongByTitleController
{
    @javafx.fxml.FXML
    private TableColumn<Song,String> genrecolumn;
    @javafx.fxml.FXML
    private TableColumn<Song,String> descriptioncolumn;
    @javafx.fxml.FXML
    private TableColumn<Song,String> songtitlecolumn;
    @javafx.fxml.FXML
    private TextField nameofthesongtextfield;
    @javafx.fxml.FXML
    private TableView<Song> songlisttableview;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;

    @javafx.fxml.FXML
    public void initialize() {
        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("songtitle"));
        descriptioncolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("description"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("genre"));

        songlisttableview.getItems().addAll(songs);
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
    public void searchOnAction(ActionEvent actionEvent) {
        if (nameofthesongtextfield.getText().isEmpty()){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name");
            erroralert.show();
            return;
        }
        songlisttableview.getItems().clear();
        for (Song s:songs){
            if (s.getSongtitle().equals(nameofthesongtextfield.getText())){
                songlisttableview.getItems().add(s);
            }
        }
        confirmationtextarea.setText("Required song has been shown");
        confirmationtextarea.setStyle("-fx-background-color: green");
    }
}