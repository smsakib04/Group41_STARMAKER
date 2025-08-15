package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Youshra.Salary;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.Salary.salaryList;

public class ApproveSalarySheetDashboardController
{
    @javafx.fxml.FXML
    private TableColumn<Salary, String> salaryAmountCol;
    @javafx.fxml.FXML
    private TableColumn<Salary, String> nameCol;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TableView<Salary> approveSalarySheetTV;

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        salaryAmountCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        approveSalarySheetTV.getItems().addAll(salaryList);
    }

    @javafx.fxml.FXML
    public void approveOA(ActionEvent actionEvent) {
        Salary s = approveSalarySheetTV.getSelectionModel().getSelectedItem();

        if (s == null) {
            confirmationMessageLabel.setText("Please select an item!");
            return;
        }
        salaryList.remove(s);
        approveSalarySheetTV.getItems().clear();
        approveSalarySheetTV.getItems().addAll(salaryList);

        confirmationMessageLabel.setText("Salary has been approved!");
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
    public void rejectOA(ActionEvent actionEvent) {
        Salary s = approveSalarySheetTV.getSelectionModel().getSelectedItem();

        if (s == null) {
            confirmationMessageLabel.setText("Please select an item!");
            return;
        }
        salaryList.remove(s);
        approveSalarySheetTV.getItems().clear();
        approveSalarySheetTV.getItems().addAll(salaryList);

        confirmationMessageLabel.setText("Salary has been rejected!");
    }
}