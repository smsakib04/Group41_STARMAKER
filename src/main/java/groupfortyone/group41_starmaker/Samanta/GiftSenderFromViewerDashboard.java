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

public class GiftSenderFromViewerDashboard
{
    @javafx.fxml.FXML
    private ComboBox giftCB;
    @javafx.fxml.FXML
    private TableColumn<Gift, String>  dateTV;
    @javafx.fxml.FXML
    private TableView <Gift> giftTV;
    @javafx.fxml.FXML
    private TableColumn<Gift, String>  toTV;
    @javafx.fxml.FXML
    private TableColumn<Gift, Integer>  amountTV;
    private Singer selectedSinger;
    private ObservableList<Gift> giftList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        giftCB.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        toTV.setCellValueFactory(new PropertyValueFactory<>("singerName"));
        amountTV.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTV.setCellValueFactory(new PropertyValueFactory<>("date"));
        giftTV.setItems(giftList);

    }

    @javafx.fxml.FXML
    public void giftSendOA(ActionEvent actionEvent) {
        if (selectedSinger == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a singer.", ButtonType.OK);
            alert.setTitle("No Singer Selected");
            alert.showAndWait();
            return;
        }

        Integer giftAmount = (Integer) giftCB.getValue();
        if ( giftAmount == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a gift amount.", ButtonType.OK);
            alert.setTitle("No Gift Amount Selected");
            alert.showAndWait();
            return;
        }
        // Get the current date
        String currentDate = java.time.LocalDate.now().toString();

        // Create a new Gift object with the selected data
        Gift newGift = new Gift(selectedSinger.getSingerName(), giftAmount, currentDate);
        giftTV.getItems().add(newGift);
        giftCB.getSelectionModel().clearSelection();;
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/SearchSingerToFollowGift.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setSelectedSinger(Singer selectedSinger) {
        this.selectedSinger = selectedSinger;
    }

}