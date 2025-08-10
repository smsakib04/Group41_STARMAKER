package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

import static groupfortyone.group41_starmaker.Raghib.Campaign.campaignList;

public class DeleteACampaignPostController
{
    @javafx.fxml.FXML
    private TableView<Campaign> campaignlisttableview;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> contentcolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> poststatuscolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> datecolumn;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> titlecolumn;

    @javafx.fxml.FXML
    public void initialize() {
        titlecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("title"));
        contentcolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("content"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("date"));
        poststatuscolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("status"));

        campaignlisttableview.getItems().addAll(campaignList);
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/MarketingExecutiveDashboard.fxml"));

            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Marketing Executive Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void deleteOnAction(ActionEvent actionEvent) {
        Campaign campaign=campaignlisttableview.getSelectionModel().getSelectedItem();
        if (campaign==null){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a campaign post");
            erroralert.show();
            return;
        }
        campaignList.remove(campaign);
        campaignlisttableview.getItems().clear();
        campaignlisttableview.getItems().addAll(campaignList);
        confirmationtextarea.setText("Campaign post has been removed");
        confirmationtextarea.setStyle("-fx-background-color: green");
    }
}