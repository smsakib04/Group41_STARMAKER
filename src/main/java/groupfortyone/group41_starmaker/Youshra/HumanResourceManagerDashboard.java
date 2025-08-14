package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HumanResourceManagerDashboard
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void handleReloadbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSearchEmployeebutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/SearchEmployeeDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleLogOutbutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/Login.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleViewEmployeebutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/ViewEmployeeListDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleRolesofEmployeesbutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/EmployeeRolesDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleAddNewStaffbutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/AddNewStaffDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleUpdateEmployeeDetailsbutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/UpdateEmployeeDetailsDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleNewRecruitmentRequestbutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/RecruitmentRequestDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleAnnouncementbutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/AnnouncementDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @javafx.fxml.FXML
    public void handleRemoveStaffbutton(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/RemoveStaffDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
}