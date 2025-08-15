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

public class CreateMonthlyIncomeDashboard {
    @javafx.fxml.FXML
    private TableColumn<MonthlyIncome, String> IncomeColumn;
    @javafx.fxml.FXML
    private TableColumn<MonthlyIncome, String> MonthColumn;
    @javafx.fxml.FXML
    private ComboBox<String> MonthComboBox;
    @javafx.fxml.FXML
    private TableView<MonthlyIncome> TableView;
    @javafx.fxml.FXML
    private TextField IncomeAmountTextField;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;

    @javafx.fxml.FXML
    public void initialize() {
        MonthComboBox.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        IncomeColumn.setCellValueFactory(new PropertyValueFactory<MonthlyIncome, String>("amount"));
        MonthColumn.setCellValueFactory(new PropertyValueFactory<MonthlyIncome, String>("month"));

    }

    @javafx.fxml.FXML
    public void handleAddbutton(ActionEvent actionEvent) {

        if (IncomeAmountTextField.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Provide an amount");
            erroralert.show();
            return;
        }
        MonthlyIncome a = new MonthlyIncome(IncomeAmountTextField.getText(),MonthComboBox.getValue());
        monthlyIncomeList.add(a);
        TableView.getItems().add(a);
        SuccessfulTextField.setText("Staff has been added successfully!");
        SuccessfulTextField.setStyle("-fx-background-color:green");


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
