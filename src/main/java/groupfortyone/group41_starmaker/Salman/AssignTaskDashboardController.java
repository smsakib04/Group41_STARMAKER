package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Salman.Task.taskList;

public class AssignTaskDashboardController
{
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TextArea assignTaskTA;
    @javafx.fxml.FXML
    private ComboBox<String> selectEmployeeCB;

    @javafx.fxml.FXML
    public void initialize() {
        selectEmployeeCB.getItems().addAll("Customer Service Officer", "Human Resource Manager", "Marketing Executive Officer");
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Salman/CEO_Dashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void sendOA(ActionEvent actionEvent) {
        if (assignTaskTA.getText().isEmpty()){
            confirmationLabel.setText("Please write any task!");
            return;

        } else if (selectEmployeeCB.getValue() == null){
            confirmationLabel.setText("Select any employee!");
            return;

        }

        Task assignTask = new Task(selectEmployeeCB.getValue(), assignTaskTA.getText());

        taskList.add(assignTask);

        confirmationLabel.setText("Task has been sent successfully!");


    }
}