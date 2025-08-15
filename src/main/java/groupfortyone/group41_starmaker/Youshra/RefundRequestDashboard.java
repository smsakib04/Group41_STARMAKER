package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RefundRequestDashboard {
    @javafx.fxml.FXML
    private TableColumn<Refund, String> RefundTypeColumn;
    @javafx.fxml.FXML
    private TableView<Refund> RequestTableView;
    @javafx.fxml.FXML
    private TableColumn<Refund, String> UsernameColumn;
    @javafx.fxml.FXML
    private TableColumn<Refund, String> AmountColumn;
    private ObservableList<Refund> RefundList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TextField ConfirmationTextField;

    @javafx.fxml.FXML
    public void initialize() {
        RefundList.add(new Refund("15000", "Angel", "Loss"));
        RefundList.add(new Refund("12000", "Bella", "Damaged Item"));
        RefundList.add(new Refund("8500", "Ravi", "Late Delivery"));
        RefundList.add(new Refund("3000", "Luna", "Wrong Product"));
        RefundList.add(new Refund("50000", "Omar", "Bulk Order Cancellation"));
        RefundList.add(new Refund("7600", "Jin", "Service Not Rendered"));
        RefundList.add(new Refund("2200", "Priya", "Duplicate Charge"));
        RefundList.add(new Refund("9800", "Carlos", "Subscription Refund"));
        RefundList.add(new Refund("1500", "Nina", "Promo Code Error"));
        RefundList.add(new Refund("4300", "David", "Customer Complaint"));
        RefundList.add(new Refund("6700", "Fatima", "Return Approved"));
        RefundTypeColumn.setCellValueFactory(new PropertyValueFactory<Refund, String>("type"));
        UsernameColumn.setCellValueFactory(new PropertyValueFactory<Refund, String>("name"));
        AmountColumn.setCellValueFactory(new PropertyValueFactory<Refund, String>("amount"));
        RequestTableView.setItems(RefundList);

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
    public void handleAcceptButton(ActionEvent actionEvent) {
        Refund acceptRefund = RequestTableView.getSelectionModel().getSelectedItem();
        if (acceptRefund == null) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a request!");
            erroralert.show();
            return;

        }
        ConfirmationTextField.setText("Request has been accepted!");
        ConfirmationTextField.setStyle("-fx-background-color: white");


    }

    @javafx.fxml.FXML
    public void handleDeclineButton(ActionEvent actionEvent) {
        Refund declineRefund = RequestTableView.getSelectionModel().getSelectedItem();
        if (declineRefund == null) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Select a request!");
            erroralert.show();
            return;

        }
        ConfirmationTextField.setText("Request has been declined!");
        ConfirmationTextField.setStyle("-fx-background-color: white");
    }
}