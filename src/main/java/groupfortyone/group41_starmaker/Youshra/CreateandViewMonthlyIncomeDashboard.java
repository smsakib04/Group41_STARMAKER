package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CreateandViewMonthlyIncomeDashboard
{
    @javafx.fxml.FXML
    private TableColumn IncomeColumn;
    @javafx.fxml.FXML
    private TableColumn MonthColumn;
    @javafx.fxml.FXML
    private ComboBox MonthComboBox;
    @javafx.fxml.FXML
    private TableView TableView;
    @javafx.fxml.FXML
    private TextField IncomeAmountTextField;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleAddbutton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleYesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlePreviousButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/AccountantDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}