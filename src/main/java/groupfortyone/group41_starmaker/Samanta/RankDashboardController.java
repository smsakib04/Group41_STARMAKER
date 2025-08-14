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

public class RankDashboardController
{

    @javafx.fxml.FXML
    private TableColumn rankTC;
    @javafx.fxml.FXML
    private TextField userIDforRankCheckTF;
    @javafx.fxml.FXML
    private TableView rankTV;
    @javafx.fxml.FXML
    private TableColumn userIDTC;

    private ObservableList<Rank> rankList= FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        rankList.add(new Rank("samanta123",1));
        rankList.add(new Rank("salman3",2));
        rankList.add(new Rank("sakira23",3));
        rankList.add(new Rank("youshra123",4));
        rankList.add(new Rank("sakhan3",5));
        rankList.add(new Rank("salma23",6));
        rankList.add(new Rank("nabiha3",7));
        rankList.add(new Rank("amir3",8));
        rankList.add(new Rank("bristy123",9));
        rankList.add(new Rank("niloy23",10));

        userIDTC.setCellValueFactory(new PropertyValueFactory<>("userID"));
        rankTC.setCellValueFactory(new PropertyValueFactory<>("rank"));

        rankTV.setItems(rankList);
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


    @javafx.fxml.FXML
    public void rankCheckOA(ActionEvent actionEvent) {
        String searchQuery = userIDforRankCheckTF.getText();
        boolean found = false;
        for (Rank rank : rankList) {
            if (rank.getUserID().contains(searchQuery)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You Are Currently Ranking on Top 10 \nYour User Name: " + rank.getUserID() + "\nYour Rank is: " + rank.getRank(), ButtonType.OK);
                alert.setTitle("Your Rank");
                alert.showAndWait();
                found = true;
                break;
            }
        }

        if (!found) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sorry, you are not currently ranking on top 10 of the leaderboard.", ButtonType.OK);
            alert.setTitle("No Search result Found");
            alert.showAndWait();
        }
    }
}