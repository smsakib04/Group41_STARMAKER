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

public class SearchSingerToFollowGiftController
{
    @javafx.fxml.FXML
    private TableView singerTV;
    @javafx.fxml.FXML
    private TextField singerNameTF;
    @javafx.fxml.FXML
    private TableColumn userIDTF;
    @javafx.fxml.FXML
    private TableColumn singerNameTC;
    private ObservableList<Singer> singersList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TableColumn isfollowingTC;


    @javafx.fxml.FXML
    public void initialize() {
        singersList.add(new Singer("Arijit Singh", "00001","NOT Following"));
        singersList.add(new Singer("Shreya Ghoshal", "00002","NOT Following"));
        singersList.add(new Singer("Lata Mangeshkar", "00003","NOT Following"));
        singersList.add(new Singer("Kishore Kumar", "00004","NOT Following"));
        singersList.add(new Singer("Sonu Nigam", "00005","NOT Following"));
        singersList.add(new Singer("Neha Kakkar", "00006","NOT Following"));
        singersList.add(new Singer("Atif Aslam", "00007","NOT Following"));
        singersList.add(new Singer("Asha Bhosle", "00008","NOT Following"));
        singersList.add(new Singer("Kumar Sanu", "00009","NOT Following"));
        singersList.add(new Singer("Badshah", "00010","NOT Following"));

        singerNameTC.setCellValueFactory(new PropertyValueFactory<>("singerName"));
        userIDTF.setCellValueFactory(new PropertyValueFactory<>("singerID"));
        isfollowingTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        singerTV.setItems(singersList);
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        String searchQuery = singerNameTF.getText();
        boolean found = false;

        for (Singer s : singersList) {
            if (s.getSingerName().toLowerCase().contains(searchQuery.toLowerCase())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Name of the Singer: " + s.getSingerName() + "\nTheir ID " + s.getSingerID() , ButtonType.OK);
                alert.setTitle("Found Your Searched Singer");
                alert.showAndWait();
                found = true;
                break;
            }
        }
        if (!found) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No Singers found matching your search.", ButtonType.OK);
            alert.setTitle("No Search Result Found");
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
    public void giftOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/GiftSenderFromViewerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void followOA(ActionEvent actionEvent) {
        Singer selectedSinger = (Singer) singerTV.getSelectionModel().getSelectedItem();
        if (selectedSinger == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a singer to follow.", ButtonType.OK);
            alert.setTitle("No Singer Selected");
            alert.showAndWait();
            return;
        }
        selectedSinger.setStatus("Following");
        singerTV.refresh();

    }
}