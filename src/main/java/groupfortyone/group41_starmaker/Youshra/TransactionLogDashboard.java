package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Youshra.MonthlyIncome.monthlyIncomeList;
import static groupfortyone.group41_starmaker.Youshra.Transaction.TransactionList;

public class TransactionLogDashboard {
    @javafx.fxml.FXML
    private Button handleAddButton;
    @javafx.fxml.FXML
    private ComboBox TypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Transaction, String> TransactionAmountColumn;
    @javafx.fxml.FXML
    private TableColumn<Transaction, String> TransactionTypeColumn;
    @javafx.fxml.FXML
    private TableView<Transaction> TransactionLogTableView;
    @javafx.fxml.FXML
    private TextField TransactionAmountTextField;

    @javafx.fxml.FXML
    public void initialize() {
        TransactionAmountColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("amount"));
        TransactionTypeColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("type"));

        TypeComboBox.getItems().addAll("Salary", "Miscallaneous");
    }

    @javafx.fxml.FXML
    public void handlePreviousButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/AccountantDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void handleAddButton(ActionEvent actionEvent) {
        if (TransactionAmountTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide an amount");
            erroralert.show();
            return;
        }
        Transaction a = new Transaction(TransactionAmountTextField.getText(), TypeComboBox.getValue());
        TransactionList.add(a);
        TransactionLogTableView.getItems().add(a);

        TransactionAmountTextField.clear();
    }
}