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
    public void initialize() throws IOException {
        genrecombobox.getItems().addAll("Pop", "Rock", "Hip-Hop", "R&B", "Country", "Romantic");

        songtitlecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("songtitle"));
        descriptioncolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("description"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<Song, String>("genre"));


//        File file = new File("songInfo.bin");
//
//        if (!file.exists()) {
//            return;
//        }
//
//        FileInputStream fis = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//
//        try{
//            while (true){
//                Song song = (Song) ois.readObject();
//                songs.add(song);
//            }
//        } catch (EOFException eof){
//            System.out.println("End of file reached");
//        } catch (ClassNotFoundException cnf) {
//            System.out.println("Class not found");
//        }
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
        if (descriptiontextfield.getText().isEmpty()){
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

        for (Song s:songs){
            if (s.getSongtitle().equals(songtitletextfield.getText())){
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

        File file = new File("songInfo.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        if (file.exists()) {
            fos = new FileOutputStream(file, true);
            oos = new AppendableObjectOutputStreamSong(fos);
        } else {
            fos = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fos);
        }
        oos.writeObject(s);
        oos.close();

        songs.add(s);
        songlisttableview.getItems().add(s);
        confirmationtextarea.setText("Song has been uploaded!");
        confirmationtextarea.setStyle("-fx-background-color: green");

        songtitletextfield.clear();
        descriptiontextfield.clear();
        genrecombobox.setValue(null);
    }
}
