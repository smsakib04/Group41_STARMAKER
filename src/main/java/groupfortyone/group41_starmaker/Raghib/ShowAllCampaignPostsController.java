package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

import static groupfortyone.group41_starmaker.Raghib.Campaign.campaignList;

public class ShowAllCampaignPostsController
{
    @javafx.fxml.FXML
    private TableView<Campaign> campaignlisttableview;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> titlecolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> contentcolumn;
    @javafx.fxml.FXML
    private TableColumn <Campaign,LocalDate>datecolumn;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TableColumn poststatuscolumn;

    @javafx.fxml.FXML
    public void initialize() {
        titlecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("title"));
        contentcolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("content"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<Campaign, LocalDate>("date"));
        poststatuscolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("status"));
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/MarketingExecutiveOfficerDashboard.fxml"));

            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Marketing Executive Officer Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void showOnAction(ActionEvent actionEvent) {
        if (campaignList.isEmpty()){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("There are no campaigns");
            erroralert.show();
            return;
        }
        campaignlisttableview.getItems().clear();
        campaignlisttableview.getItems().addAll(campaignList);
        confirmationtextarea.setText("All posts have been shown");
        confirmationtextarea.setStyle("-fx-background-color: green");
    }
}