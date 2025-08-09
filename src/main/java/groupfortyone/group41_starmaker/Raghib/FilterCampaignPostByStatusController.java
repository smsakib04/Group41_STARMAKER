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

public class FilterCampaignPostByStatusController
{
    @javafx.fxml.FXML
    private TableView campaignlisttableview;
    @javafx.fxml.FXML
    private TableColumn titlecolumn;
    @javafx.fxml.FXML
    private TableColumn contentcolumn;
    @javafx.fxml.FXML
    private TableColumn datecolumn;
    @javafx.fxml.FXML
    private RadioButton expiredradiobutton;
    @javafx.fxml.FXML
    private RadioButton activeradiobutton;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TableColumn poststatuscolumn;

    @javafx.fxml.FXML
    public void initialize() {
        ToggleGroup tg=new ToggleGroup();
        activeradiobutton.setToggleGroup(tg);
        expiredradiobutton.setToggleGroup(tg);

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
    public void filterOnAction(ActionEvent actionEvent) {
        campaignlisttableview.getItems().clear();
        if ((!activeradiobutton.isSelected()) && (!expiredradiobutton.isSelected())){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select Post Status");
            erroralert.show();
            return;
        }
        String SelectStatus=" ";
        if (activeradiobutton.isSelected()){
            SelectStatus="Active";
        }
        if (expiredradiobutton.isSelected()){
            SelectStatus="Expired";
        }
        for (Campaign c:campaignList){
            if (c.getStatus().equals(SelectStatus)){
                campaignlisttableview.getItems().add(c);

            }
        }
    }
}