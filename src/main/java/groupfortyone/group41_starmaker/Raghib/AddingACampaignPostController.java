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
import java.util.ArrayList;

import static groupfortyone.group41_starmaker.Raghib.Campaign.campaignList;

public class AddingACampaignPostController
{
    @javafx.fxml.FXML
    private TextField titletextfield;
    @javafx.fxml.FXML
    private DatePicker datedatepicker;
    @javafx.fxml.FXML
    private TableView<Campaign> campaignlisttableview;
    @javafx.fxml.FXML
    private TextField contenttextfield;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> titlecolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> contentcolumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> poststatuscolumn;
    @javafx.fxml.FXML
    private RadioButton expiredradiobutton;
    @javafx.fxml.FXML
    private RadioButton activeradiobutton;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> datecolumn;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;




    @javafx.fxml.FXML
    public void initialize() {
        ToggleGroup tg=new ToggleGroup();
        activeradiobutton.setToggleGroup(tg);
        expiredradiobutton.setToggleGroup(tg);

        titlecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("title"));
        contentcolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("content"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("date"));
        poststatuscolumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("status"));
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
    public void saveOnaction(ActionEvent actionEvent) {
        String SelectStatus=" ";
        if (activeradiobutton.isSelected()){
            SelectStatus="Active";
        }
        if (expiredradiobutton.isSelected()){
            SelectStatus="Expired";
        }

        if (titletextfield.getText().isEmpty()){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a title");
            erroralert.show();
            return;
        }
        if (contenttextfield.getText().isEmpty()){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a content");
            erroralert.show();
            return;
        }
        if (datedatepicker.getValue()==null){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a date");
            erroralert.show();
            return;
        }
        if ((!activeradiobutton.isSelected()) && (!expiredradiobutton.isSelected())){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide status");
            erroralert.show();
            return;
        }
        if (datedatepicker.getValue().isAfter(LocalDate.now())){
            Alert erroralert=new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide valid date");
            erroralert.show();
            return;
        }
        for (Campaign c:campaignList){
            if (c.getTitle().equals(titletextfield.getText())){
                Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("Post title should be unique");
                erroralert.show();
                return;
            }
        }
        Campaign c= new Campaign(
                titletextfield.getText(),
                contenttextfield.getText(),
                datedatepicker.getValue(),
                SelectStatus);

        campaignList.add(c);
        campaignlisttableview.getItems().clear();
        campaignlisttableview.getItems().addAll(campaignList);
        confirmationtextarea.setText("Campaign Post has been added");
        confirmationtextarea.setStyle("-fx-background-color: green");

        titletextfield.clear();
        contenttextfield.clear();
        datedatepicker.setValue(null);
        activeradiobutton.setSelected(false);
        expiredradiobutton.setSelected(false);
    }
}