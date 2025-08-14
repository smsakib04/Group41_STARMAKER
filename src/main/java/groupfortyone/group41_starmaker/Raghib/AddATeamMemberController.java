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

import static groupfortyone.group41_starmaker.Raghib.Profile.profileList;

public class AddATeamMemberController
{
    @javafx.fxml.FXML
    private DatePicker dobdatepicker;
    @javafx.fxml.FXML
    private TextField nametextfield;
    @javafx.fxml.FXML
    private TextField emailtextfield;
    @javafx.fxml.FXML
    private ComboBox<String> bloodgroupcombobox;
    @javafx.fxml.FXML
    private RadioButton unmarriedradiobutton;
    @javafx.fxml.FXML
    private TableView<Profile> profiletableview;
    @javafx.fxml.FXML
    private TableColumn<Profile,String> agecolumn;
    @javafx.fxml.FXML
    private TableColumn<Profile,String> namecolumn;
    @javafx.fxml.FXML
    private TableColumn<Profile,String> dobcolumn;
    @javafx.fxml.FXML
    private RadioButton marriedradiobutton;
    @javafx.fxml.FXML
    private TableColumn<Profile,String> bloodgroupcolumn;
    @javafx.fxml.FXML
    private TableColumn<Profile,String>emailcolumn;
    @javafx.fxml.FXML
    private TextField agetextfield;
    @javafx.fxml.FXML
    private TableColumn<Profile,String>maritalstatuscolumn;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;

    @javafx.fxml.FXML
    public void initialize() {
        ToggleGroup tg= new ToggleGroup();
        marriedradiobutton.setToggleGroup(tg);
        unmarriedradiobutton.setToggleGroup(tg);

        bloodgroupcombobox.getItems().addAll("A+","A-","B+","B-","AB+","AB-","O-","O+");

        namecolumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("name"));
        emailcolumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("email"));
        agecolumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("age"));
        dobcolumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("dob"));
        bloodgroupcolumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("bloodgroup"));
        maritalstatuscolumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("maritalstatus"));
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/MarketingExecutiveOfficerDashboard.fxml"));

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
    public void saveOnAction(ActionEvent actionEvent) {
        if (nametextfield.getText().isEmpty()){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a name");
            erroralert.show();
            return;
        }
        if (emailtextfield.getText().isEmpty()){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide an email");
            erroralert.show();
            return;
        }
        if (agetextfield.getText().isEmpty()){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide age");
            erroralert.show();
            return;
        }
        int age;
        try{
            age = Integer.parseInt(agetextfield.getText());
        } catch (NumberFormatException e) {
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Enter an integer number");
            erroralert.show();
            return;
        }
        if (dobdatepicker.getValue()==null){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide DOB");
            erroralert.show();
            return;
        }
        if (bloodgroupcombobox.getValue()==null){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide blood group");
            erroralert.show();
            return;
        }
        if ((!marriedradiobutton.isSelected() && (!unmarriedradiobutton.isSelected()))){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide marital status");
            erroralert.show();
            return;
        }

        if (dobdatepicker.getValue().isAfter(LocalDate.now())){
            Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide a valid DOB");
            erroralert.show();
            return;
        }
        String maritalStatus="";
        if (marriedradiobutton.isSelected()){
            maritalStatus="Married";
        }
        if (unmarriedradiobutton.isSelected()){
            maritalStatus="Unmarried";
        }
        for (Profile p:profileList){
            if (p.getName().equals(nametextfield.getText())){
                Alert erroralert= new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("Provide a unique name");
                erroralert.show();
                return;
            }

        }
        Profile p=new Profile(
                nametextfield.getText(),
                emailtextfield.getText(),
                age,
                dobdatepicker.getValue(),
                bloodgroupcombobox.getValue(),
                maritalStatus);
        profileList.add(p);
        profiletableview.getItems().addAll(profileList);
        confirmationtextarea.setText("Profile has been added successfully");
        confirmationtextarea.setStyle("-fx-background-color: green");

        nametextfield.clear();
        emailtextfield.clear();
        agetextfield.clear();
        dobdatepicker.setValue(null);
        bloodgroupcombobox.setValue(null);
        marriedradiobutton.setSelected(false);
        unmarriedradiobutton.setSelected(false);
    }
}