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

public class LiveSearchDashboardController
{
    @javafx.fxml.FXML
    private TextField nameoftheLiveTF;
    @javafx.fxml.FXML
    private TableColumn <LiveBroadcast, String>livedateTC;
    @javafx.fxml.FXML
    private TableColumn<LiveBroadcast, String> livetitleTC;
    @javafx.fxml.FXML
    private TableColumn <LiveBroadcast, String>descriptionTC;
    public  ObservableList<LiveBroadcast> allBroadcastList= FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public TableView <LiveBroadcast> livesearchTV;


    @javafx.fxml.FXML
    public void initialize() {


        livetitleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        livedateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        livesearchTV.setItems(allBroadcastList);
        broadcastData();


    }

    protected void broadcastData() {
        allBroadcastList.add(new LiveBroadcast("PUBG LIVE STREAM", "a gaming stream of today's gameplay", "06/01/2025", 23));
        allBroadcastList.add(new LiveBroadcast("Cooking Masterclass", "Learn new recipes and cooking tips live", "06/02/2025", 778));
        allBroadcastList.add(new LiveBroadcast("Tech Talk", "Discussion on the latest tech trends and innovations", "06/03/2025", 54));
        allBroadcastList.add(new LiveBroadcast("Music Festival Live", "A live broadcast of an outdoor music festival", "06/04/2025", 304));
        allBroadcastList.add(new LiveBroadcast("Fitness Live", "Live workout session with fitness experts", "06/05/2025", 43));
        allBroadcastList.add(new LiveBroadcast("Movie Night", "Watch a live screening of a popular movie", "06/06/2025", 0));
        allBroadcastList.add(new LiveBroadcast("Travel Vlog", "Join the host on an exciting travel journey", "06/07/2025", 4244));
        allBroadcastList.add(new LiveBroadcast("Science Show", "Explore the wonders of science through live demonstrations", "06/08/2025", 423));
        allBroadcastList.add(new LiveBroadcast("Art Workshop", "Live painting and art lessons from professional artists", "06/09/2025", 44));
    }


    @javafx.fxml.FXML
    public void nameoftheLiveOA(ActionEvent actionEvent) {
    }

    @Deprecated
    public void gobackOA(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void searchOA(ActionEvent actionEvent) {
        String searchQuery = nameoftheLiveTF.getText();
        boolean found = false;

        for (LiveBroadcast broadcast : allBroadcastList) {
            if (broadcast.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Title: " + broadcast.getTitle() + "\nDescription of the Stream: " + broadcast.getDescription() + "\nBroadcast Date: " + broadcast.getDate(), ButtonType.OK);
                alert.setTitle("Live Broadcast Found");
                alert.showAndWait();
                found = true;
                break;
            }
        }
        if (!found) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No Lives found matching your search.", ButtonType.OK);
            alert.setTitle("No Search Result Found");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
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
}