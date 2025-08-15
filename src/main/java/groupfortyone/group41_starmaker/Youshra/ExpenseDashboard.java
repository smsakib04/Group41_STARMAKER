package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.Expense.expense;
import static groupfortyone.group41_starmaker.Youshra.MonthlyIncome.monthlyIncomeList;

public class ExpenseDashboard
{
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TableColumn<Expense,String> AmountColumn;
    @javafx.fxml.FXML
    private TextField ExpenseTypeTextField;
    @javafx.fxml.FXML
    private Label RecordedSuccessfullyLabel;
    @javafx.fxml.FXML
    private TableColumn<Expense,String> ExpenseTypeColumn;
    @javafx.fxml.FXML
    private TableView<Expense> ExpenseRecordTableView;

    @javafx.fxml.FXML
    public void initialize() {
        AmountColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("amount"));
        ExpenseTypeColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("type"));
    }

    @javafx.fxml.FXML
    public void handleAddbutton(ActionEvent actionEvent) {

        if (amountTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide an amount");
            erroralert.show();
            return;
        }

        if (ExpenseTypeTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide an amount");
            erroralert.show();
            return;
        }
        Expense a = new Expense(ExpenseTypeTextField.getText(),amountTextField.getText());
        expense.add(a);
        ExpenseRecordTableView.getItems().add(a);

        RecordedSuccessfullyLabel.setText("Staff has been added successfully!");
        RecordedSuccessfullyLabel.setStyle("-fx-background-color:green");

        ExpenseTypeTextField.clear();
        amountTextField.clear();
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