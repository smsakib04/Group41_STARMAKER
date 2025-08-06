package groupfortyone.group41_starmaker.Raghib;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewTotalNumberOfLikesOfASongController
{
    @javafx.fxml.FXML
    private Label totallikesofasonglabel;
    @javafx.fxml.FXML
    private TableView songlisttableview;
    @javafx.fxml.FXML
    private TableColumn numberoflikescolumn;
    @javafx.fxml.FXML
    private TableColumn descriptioncolumn;
    @javafx.fxml.FXML
    private TableColumn songtitlecolumn;
    @javafx.fxml.FXML
    private TableColumn genrecolumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void showOnAction(ActionEvent actionEvent) {
    }
}