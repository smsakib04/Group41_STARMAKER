package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SalarySheetApprovalDashboard
{
    @javafx.fxml.FXML
    private TableColumn EmployeeRoleColumn;
    @javafx.fxml.FXML
    private Label SuccessfulLabel;
    @javafx.fxml.FXML
    private TableColumn SalaryColumn;
    @javafx.fxml.FXML
    private TableColumn EmployeeNameColumn;
    @javafx.fxml.FXML
    private TableView SalarySheetTableView;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handlePreviousPagebutton(ActionEvent actionEvent) {
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


    @javafx.fxml.FXML
    public void handleSentToCEObutton(ActionEvent actionEvent) {
    }
}