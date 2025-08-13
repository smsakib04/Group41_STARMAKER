package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SendCampaignUpdatesToTeamMembers
{
    @javafx.fxml.FXML
    private ListView campaignnoteslistview;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TextField sendcampaignupdatestextfield;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void addcampaignnotesOnAction(ActionEvent actionEvent) {
        if (sendcampaignupdatestextfield.getText().isEmpty()){
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Give some updates");
            erroralert.show();
            return;
        }
        campaignnoteslistview.getItems().addAll(sendcampaignupdatestextfield.getText());
        confirmationtextarea.setText("Updates have been sent successfully");
        confirmationtextarea.setStyle("-fx-background-color: green");
        sendcampaignupdatestextfield.clear();
    }
}