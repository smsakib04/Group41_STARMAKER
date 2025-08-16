package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Campaign.campaignList;

public class EditCampaignPostsController
{
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> newstatuscolumn;
    @javafx.fxml.FXML
    private TableView<Campaign> newcampaignlisttableview;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> newcontentcolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> newdatecolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> newtitlecolumn;
    @javafx.fxml.FXML
    private TextField newcontenttextfield;
    @javafx.fxml.FXML
    private RadioButton newexpiredradiobutton;
    @javafx.fxml.FXML
    private DatePicker newdatepicker;
    @javafx.fxml.FXML
    private TextField newtitletextfield;
    @javafx.fxml.FXML
    private RadioButton newactiveradiobutton;
    @javafx.fxml.FXML
    private TextArea Confirmationtextarea;

    @javafx.fxml.FXML
    public void initialize() {
        ToggleGroup tg=new ToggleGroup();
        newactiveradiobutton.setToggleGroup(tg);
        newexpiredradiobutton.setToggleGroup(tg);

        newtitlecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("title"));
        newcontentcolumn.setCellValueFactory(new  PropertyValueFactory<Campaign,String>("content"));
        newdatecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("date"));
        newstatuscolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("status"));

        newcampaignlisttableview.getItems().addAll(campaignList);
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
    public void savechangesOnAction(ActionEvent actionEvent) {
        Campaign campaign=newcampaignlisttableview.getSelectionModel().getSelectedItem();
        if (campaign==null){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a campaign post to edit");
            erroralert.show();
            return;
        }
        if (!newtitletextfield.getText().isEmpty()){
            campaign.setTitle(newtitletextfield.getText());
        }
        if (!newcontenttextfield.getText().isEmpty()) {
            campaign.setContent(newcontenttextfield.getText());
        }
        if (newdatepicker.getValue()!=null){
            campaign.setDate(newdatepicker.getValue());
        }
        String newStatus="";
        if (newactiveradiobutton.isSelected()){
            newStatus="Active";
            campaign.setStatus(newStatus);
        }
        if (newexpiredradiobutton.isSelected()){
            newStatus="Expired";
            campaign.setStatus(newStatus);
        }
        newcampaignlisttableview.refresh();
        newtitletextfield.clear();
        newcontenttextfield.clear();
        newdatepicker.setValue(null);
        newactiveradiobutton.setSelected(false);
        newexpiredradiobutton.setSelected(false);
        Confirmationtextarea.setText("Post has been updated");
        Confirmationtextarea.setStyle("-fx-background-color: green");
    }
}