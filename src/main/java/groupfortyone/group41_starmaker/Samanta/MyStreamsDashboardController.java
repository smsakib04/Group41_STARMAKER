package groupfortyone.group41_starmaker.Samanta;

import groupfortyone.group41_starmaker.HelloApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MyStreamsDashboardController extends LiveSearchDashboardController {

    @javafx.fxml.FXML
    private TableColumn <LiveBroadcast, String>StreamNameTC;
    @javafx.fxml.FXML
    private TableColumn<LiveBroadcast, String> StreamDateTC;
    @javafx.fxml.FXML
    private TableColumn<LiveBroadcast, Integer> totalGiftReceivedTC;
    @javafx.fxml.FXML
    private TableView<LiveBroadcast> streamsTV;
    @javafx.fxml.FXML
    private TableColumn<LiveBroadcast, Integer> sharePlatformTC;
    @javafx.fxml.FXML
    private ComboBox <String>sharePlatformCB;

    @javafx.fxml.FXML
    public void initialize() {
        super.broadcastData();
        sharePlatformCB.getItems().addAll("Facebook","Whatsapp","Twitter","Instagram","Youtube","Messenger","Telegram");

        StreamNameTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        StreamDateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        totalGiftReceivedTC.setCellValueFactory(new PropertyValueFactory<>("gift"));
        streamsTV.setItems(allBroadcastList);
        sharePlatformTC.setCellValueFactory(new PropertyValueFactory<>("platform"));
        streamsTV.setItems(allBroadcastList);




    }


    @javafx.fxml.FXML
    public void ShareStreamBT(ActionEvent actionEvent) {
        LiveBroadcast selectedStream = streamsTV.getSelectionModel().getSelectedItem();

        if (selectedStream == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Please select a stream to share.");
            alert.show();
            return;
        }
        String selectedPlatform = sharePlatformCB.getSelectionModel().getSelectedItem();

        if (selectedPlatform == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Please select a platform.");
            alert.show();
            return;
        }
        if (selectedStream.getPlatform().equals("Not shared")) {
            selectedStream.setPlatform(selectedPlatform);
            streamsTV.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Stream has been shared on " + selectedPlatform, ButtonType.OK);
            alert.setTitle("Share Confirmation");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "This stream has already been shared.", ButtonType.OK);
            alert.setTitle("Already Shared");
            alert.showAndWait();
        }

    }

    @javafx.fxml.FXML
    public void previousBTOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/LiveBroadcasterDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void deleteStreamOA(ActionEvent actionEvent) {
        LiveBroadcast selectedStream = streamsTV.getSelectionModel().getSelectedItem();

        if (selectedStream==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Select a Broadcast to delete");
            alert.show();
            return;
        }
        allBroadcastList.remove(selectedStream);
        streamsTV.getItems().remove(selectedStream);
        streamsTV.getSelectionModel().clearSelection();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, selectedStream.getTitle() + " has been deleted.", ButtonType.OK);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}