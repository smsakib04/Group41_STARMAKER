package groupfortyone.group41_starmaker.Raghib;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EditSongTitleController
{
    @javafx.fxml.FXML
    private TableView songlisttableview;
    @javafx.fxml.FXML
    private TableColumn genrecolumn;
    @javafx.fxml.FXML
    private TableColumn descriptioncolumn;
    @javafx.fxml.FXML
    private TableColumn songtitlecolumn;
    @javafx.fxml.FXML
    private TextField newnametextfield;
    @javafx.fxml.FXML
    private Label confirmationlabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void savechangesOnAction(ActionEvent actionEvent) {
    }
}