package groupfortyone.group41_starmaker.Salman;

import groupfortyone.group41_starmaker.HelloApplication;
import groupfortyone.group41_starmaker.Raghib.Query;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static groupfortyone.group41_starmaker.Raghib.Query.queryList;

public class SearchQueryDashboardController
{

    @javafx.fxml.FXML
    private TextField searchQueryTF;
    @javafx.fxml.FXML
    private TableView<Query> searchTV;
    @javafx.fxml.FXML
    private TableColumn<Query, String> queryCol;
    @javafx.fxml.FXML
    private TableColumn<Query, String> nameCol;

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        queryCol.setCellValueFactory(new PropertyValueFactory<>("query"));
    }

    @javafx.fxml.FXML
    public void viewOA(ActionEvent actionEvent) {

        searchTV.getItems().addAll(queryList);

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
    public void searchOA(ActionEvent actionEvent) {
        searchTV.getItems().clear();
        for (Query x: queryList){
            if (searchQueryTF.getText().equals(x.getUsername())){
                searchTV.getItems().add(x);
            }
        }
    }
}