package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountantDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSalarySheet(ActionEvent actionEvent) {    try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/SalarySheetApprovalDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }

    @javafx.fxml.FXML
    public void handleRecordExpense(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/ExpenseDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }

    @javafx.fxml.FXML
    public void handleRefundRequest(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/RefundRequestDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleGenerateMonthlyIncome(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/CreateandViewMonthlyIncomeDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleGenerateFinancialReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCreateSalarySheet(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/SalarySheetDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleArtistPayout(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/ArtistPayoutDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleTransactionLog(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/TransactionLogDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleLoad(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLogOut(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
}