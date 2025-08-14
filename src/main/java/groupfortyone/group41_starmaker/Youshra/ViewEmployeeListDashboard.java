package groupfortyone.group41_starmaker.Youshra;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ViewEmployeeListDashboard
{
    @javafx.fxml.FXML
    private TableColumn EmployeeTypeColumn;
    @javafx.fxml.FXML
    private TableColumn EmployeeRoleColumn;
    @javafx.fxml.FXML
    private TableView EmployeeListTableView;
    @javafx.fxml.FXML
    private TableColumn EmployeeIDColumn;
    @javafx.fxml.FXML
    private TableColumn EmployeeListColumn;
    @javafx.fxml.FXML
    private TableColumn DepartmentColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleViewButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlePreviousbutton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/HumanResourceManagerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}