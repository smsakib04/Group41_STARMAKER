package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Locale;

import static groupfortyone.group41_starmaker.Salman.Meeting.meetingList;

public class ScheduleMeetingDashboardController
{
    @javafx.fxml.FXML
    private DatePicker meetingDateDP;
    @javafx.fxml.FXML
    private TableColumn<Meeting, String> meetingTopicCol;
    @javafx.fxml.FXML
    private TableColumn<Meeting, LocalDate> meetingDateCol;
    @javafx.fxml.FXML
    private TableView<Meeting> meetingTV;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TextField meetingTopicTF;

    @javafx.fxml.FXML
    public void initialize() {
        meetingTopicCol.setCellValueFactory(new PropertyValueFactory<>("meetingTopic"));
        meetingDateCol.setCellValueFactory(new PropertyValueFactory<>("meetingDate"));
    }

    @javafx.fxml.FXML
    public void confirmOA(ActionEvent actionEvent) {
        if (meetingTopicTF.getText().isEmpty()){
            confirmationMessageLabel.setText("Please type the meeting topic!");
            return;
        } else if (meetingDateDP.getValue()== null) {
            confirmationMessageLabel.setText("Please select any date for the meeting!");
            return;
        } else if (meetingTopicTF.getText().isEmpty() && meetingDateDP.getValue()==null) {
            confirmationMessageLabel.setText("Please write meeting's topic and choose any date!");

        }

        Meeting meeting = new Meeting(
                meetingTopicTF.getText(),
                meetingDateDP.getValue()
        );

        meetingList.add(meeting);
        meetingTV.getItems().clear();
        meetingTV.getItems().addAll(meetingList);

        confirmationMessageLabel.setText("Meeting has been created successfully!");

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

    @Deprecated
    public void confirmationMessageLabel(Event event) {
    }
}