package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Raghib.Song;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RepostSongDashboardController
{
    @javafx.fxml.FXML
    private TextField repostCaptionTF;
    @javafx.fxml.FXML
    private ComboBox<String> privacyCB;
    @javafx.fxml.FXML
    private TextField usernameTF;
    @javafx.fxml.FXML
    private RadioButton yesornoRB;
    @javafx.fxml.FXML
    private Label repostSummaryLB;

    private Song selectedSong;


    @javafx.fxml.FXML
    public void initialize() {
        privacyCB.getItems().addAll("Public", "Private", "Friends");

    }


    @javafx.fxml.FXML
    public void repostToProfileOA(ActionEvent actionEvent) {
        String username = usernameTF.getText();
        String caption = repostCaptionTF.getText();
        String privacy = privacyCB.getValue();
        boolean isAnonymous = yesornoRB.isSelected();

        if (isAnonymous) {
            username = "Anonymous";
        }

        String repostSummary = "Song: " + selectedSong.getSongtitle() + "\n" +
                "Caption: " + caption + "\n" +
                "Privacy: " + privacy + "\n" +
                "User: " + username;
        repostSummaryLB.setText(repostSummary + "\nReposted successfully!");
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/CommentDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void setSongDetails(Song selectedSong) {
        this.selectedSong = selectedSong;
    }
}