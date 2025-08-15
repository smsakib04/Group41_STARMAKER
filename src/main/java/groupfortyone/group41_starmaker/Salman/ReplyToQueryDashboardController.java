package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Raghib.Query;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Query.queryList;

public class ReplyToQueryDashboardController
{
    @javafx.fxml.FXML
    private TableView<Query> replyQueryTV;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private TextArea replyTA;
    @javafx.fxml.FXML
    private TableColumn<Query, String> queryCol;
    @javafx.fxml.FXML
    private TableColumn<Query, String> nameCol;

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        queryCol.setCellValueFactory(new PropertyValueFactory<>("query"));

        replyQueryTV.getItems().addAll(queryList);
    }

    @javafx.fxml.FXML
    public void previousOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Salman/CSO_Dashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void sendOA(ActionEvent actionEvent) {
        if (replyTA.getText().isEmpty()){
            confirmationMessageLabel.setText("Please type your reply first!");
            return;
        }
        Query q = replyQueryTV.getSelectionModel().getSelectedItem();
        if (q == null) {
            confirmationMessageLabel.setText("");
            return;
        }


        confirmationMessageLabel.setText("Reply sent successfully!");

    }
}