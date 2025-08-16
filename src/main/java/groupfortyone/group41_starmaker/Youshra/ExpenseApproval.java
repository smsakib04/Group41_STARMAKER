package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExpenseApproval
{
    @javafx.fxml.FXML
    private TextField AmountTextField;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;

    public static ArrayList<Expense> expense = new ArrayList<Expense>();
    @javafx.fxml.FXML
    private ComboBox ExpenseTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        ExpenseTypeComboBox.getItems().addAll("Salary", "Equipment","Stationary","Miscalleneous");
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

    @javafx.fxml.FXML
    public void handleSendRequestButton(ActionEvent actionEvent) {
        String amount = AmountTextField.getText();

        if (AmountTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide an amount");
            erroralert.show();
            return;

        }

        SuccessfulTextField.setText("Request Sent successfully!");
        SuccessfulTextField.setStyle("-fx-background-color: green");

    }
}