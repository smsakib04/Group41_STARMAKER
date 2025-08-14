package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

import static groupfortyone.group41_starmaker.Raghib.Song.songs;


public class UploadASongController {
    @javafx.fxml.FXML
    private TextField songtitletextfield;
    @javafx.fxml.FXML
    private TableView<Song> songlisttableview;
    @javafx.fxml.FXML
    private TableColumn<Song, String> genrecolumn;
    @javafx.fxml.FXML
    private ComboBox<String> genrecombobox;
    @javafx.fxml.FXML
    private TableColumn<Song, String> descriptioncolumn;
    @javafx.fxml.FXML
    private TableColumn<Song, String> songtitlecolumn;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TextField descriptiontextfield;
    @javafx.fxml.FXML
    private Label confirmationlabel;


    @javafx.fxml.FXML
    public void initialize() throws IOException {
        genrecombobox.getItems().addAll("Pop", "Rock", "Hip-Hop", "R&B", "Country", "Romantic");

        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("songtitle"));
        descriptioncolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("description"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("genre"));

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("songinfo.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);

            } else {
                Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("");
                erroralert.show();
            }
            if (fis != null) {
                ois = new ObjectInputStream(fis);
            }
            while (true) {
                songlisttableview.getItems().add((Song) ois.readObject());
            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {
            }
        }
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/SingerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Singer Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void uploadasongOnAction(ActionEvent actionEvent) throws IOException {
        if (songtitletextfield.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Fillup the song title");
            erroralert.show();
            return;
        }
        if (descriptiontextfield.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Fillup the song description");
            erroralert.show();
            return;
        }
        if (genrecombobox.getValue() == null) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Choose the song genre");
            erroralert.show();
            return;
        }

        for (Song s : songs) {
            if (s.getSongtitle().equals(songtitletextfield.getText())) {
                Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("Song title should be unique");
                erroralert.show();
                return;
            }

        }
        Song s = new Song(
                songtitletextfield.getText(),
                descriptiontextfield.getText(),
                genrecombobox.getValue());

        songs.add(s);
        songlisttableview.getItems().add(s);
        confirmationtextarea.setText("Song has been uploaded!");
        confirmationtextarea.setStyle("-fx-background-color: green");

        songtitletextfield.clear();
        descriptiontextfield.clear();
        genrecombobox.setValue(null);
    }


    @javafx.fxml.FXML
    public void writeinbinfileOnAction(ActionEvent actionEvent) {
        try {
            File f = new File("songinfo.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            }
            for (Song s : songs) {
                oos.writeObject(s);
            }
            oos.close();
        } catch (Exception e) {

        }
    }
}