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

public class SearchACampaignPostByMonthAndStatusController
{
    @javafx.fxml.FXML
    private TableView<Campaign> campaignlisttableview;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> contentcolumn;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;
    @javafx.fxml.FXML
    private TextField initialmonthtextfield;
    @javafx.fxml.FXML
    private TextField finalmonthtextfield;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> statuscolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> titlecolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> datecolumn;
    @javafx.fxml.FXML
    private RadioButton activeradiobutton;
    @javafx.fxml.FXML
    private RadioButton expiredradioButton;

    @javafx.fxml.FXML
    public void initialize() {
        ToggleGroup tg=new ToggleGroup();
        activeradiobutton.setToggleGroup(tg);
        expiredradioButton.setToggleGroup(tg);

        titlecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("title"));
        contentcolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("content"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("date"));
        statuscolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("status"));


        campaignlisttableview.getItems().addAll(campaignList);
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
    public void searchOnAction(ActionEvent actionEvent) {
        campaignlisttableview.getItems().clear();
        if (initialmonthtextfield.getText().isEmpty()){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide initial month");
            erroralert.show();
            return;
        }
        if (finalmonthtextfield.getText().isEmpty()){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide final month");
            erroralert.show();
            return;
        }
        int num;
        try{
            num=Integer.parseInt(initialmonthtextfield.getText());
        }catch (NumberFormatException e){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a number in initial month");
            erroralert.show();
            return;
        }
        int num2;
        try{
            num2=Integer.parseInt(finalmonthtextfield.getText());
        }catch (NumberFormatException e) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a number in final month");
            erroralert.show();
            return;
        }
        if((!activeradiobutton.isSelected()) && (!expiredradioButton.isSelected())){
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select post status");
            erroralert.show();
            return;
        }
        String Selectstatus="";
        if (activeradiobutton.isSelected()){
            Selectstatus="Active";
        }
        if (expiredradioButton.isSelected()){
            Selectstatus="Expired";
        }
        for (Campaign c:campaignList){
            if ((Integer.parseInt(initialmonthtextfield.getText())<=c.getDate().getMonthValue() && ((Integer.parseInt(finalmonthtextfield.getText())>=c.getDate().getMonthValue()) && c.getStatus().equals(Selectstatus)))){
                campaignlisttableview.refresh();
                campaignlisttableview.getItems().addAll(c);
                confirmationtextarea.setText("Filtered posts have been shown");
                confirmationtextarea.setStyle("-fx-background-color: green");
            }
        }
    }
}