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

public class FollowersDashboardController
{

    @javafx.fxml.FXML
    private TableColumn<String, Follower> followerNameTC;
    @javafx.fxml.FXML
    private TableColumn <String, Follower> followerIDTC;
    @javafx.fxml.FXML
    private TableView<Follower>  followersTable;
    @javafx.fxml.FXML
    private TableColumn <String, Follower> followingFollowerNameTC;
    @javafx.fxml.FXML
    private TableColumn<String, Follower>  followingFollowerIDTC;
    @javafx.fxml.FXML
    private TableView <Follower> followingFollowerTC;
    private ObservableList<Follower> followersList = FXCollections.observableArrayList();
    private ObservableList<Follower> followingFollowerList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        followersList.add(new Follower("Sakib Khan", "00010", false));
        followersList.add(new Follower("Salman Khan", "00011", false));
        followersList.add(new Follower("Shahrukh Khan", "00103", false));
        followersList.add(new Follower("Tikka Khan", "00104", false));
        followersList.add(new Follower("Deepika Padukone", "00106", false));
        followersList.add(new Follower("Aamir Khan", "00107", false));
        followersList.add(new Follower("Katrina Kaif", "00108", false));
        followersList.add(new Follower("Ranbir Kapoor", "00109", false));
        followersList.add(new Follower("Priyanka Chopra", "00110", false));
        followersList.add(new Follower("Huda Khan", "00111", false));
        followersList.add(new Follower("Alia Bhatt", "00112", false));
        followersList.add(new Follower("Akshay Kumar", "00113", false));
        followersList.add(new Follower("Kareena Kapoor", "00114", false));



        followerNameTC.setCellValueFactory(new PropertyValueFactory<>("followerName"));
        followerIDTC.setCellValueFactory(new PropertyValueFactory<>("followerID"));
        followersTable.setItems(followersList);



        followingFollowerNameTC.setCellValueFactory(new PropertyValueFactory<>("followerName"));
        followingFollowerIDTC.setCellValueFactory(new PropertyValueFactory<>("followerID"));
        followingFollowerTC.setItems(followingFollowerList);
    }

    @javafx.fxml.FXML
    public void followOA(ActionEvent actionEvent) {
        Follower selectedFollower = followersTable.getSelectionModel().getSelectedItem();
        if (selectedFollower==null){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a Follower to Follow Back");
            erroralert.show();
            return;
        }
        for (Follower s : followingFollowerList) {
            if (s == selectedFollower) {
                Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("You are already Following this User");
                erroralert.show();
                return;
            }
        }
        followingFollowerList.add(selectedFollower);
        followingFollowerTC.setItems(followingFollowerList);
        followersTable.getSelectionModel().clearSelection();
    }


    @javafx.fxml.FXML
    public void messageFollowerOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/MessageFollowerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/LiveBroadcasterDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void blockFollowerOA(ActionEvent actionEvent) {
        Follower selectedFollower = followersTable.getSelectionModel().getSelectedItem();
        if (selectedFollower != null) {
            selectedFollower.setBlocked(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, selectedFollower.getFollowerName() + " has been blocked.", ButtonType.OK);
            alert.setTitle("Block Confirmation");
            alert.setHeaderText(null);
            alert.showAndWait();
            followersTable.getItems().remove(selectedFollower);
            followersTable.getSelectionModel().clearSelection();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a follower to block.", ButtonType.OK);
            alert.setTitle("No Follower Selected");
            alert.showAndWait();
        }
    }

}