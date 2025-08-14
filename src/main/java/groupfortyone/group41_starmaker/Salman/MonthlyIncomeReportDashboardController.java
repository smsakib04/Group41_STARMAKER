package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MonthlyIncomeReportDashboardController
{
    @javafx.fxml.FXML
    private Label monthlyIncomeReportLabel;
    @javafx.fxml.FXML
    private ComboBox chooseMonthCB;

    @javafx.fxml.FXML
    public void initialize() {
        chooseMonthCB.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");



    }

    @javafx.fxml.FXML
    public void viewMonthlyIncomeOA(ActionEvent actionEvent) {
        if (chooseMonthCB.getValue() == null) {
            monthlyIncomeReportLabel.setText("Please choose a month!");
        }else {
            monthlyIncomeReportLabel.setText("The Monthly Income of StarMaker for the chosen month is");
        }
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
}