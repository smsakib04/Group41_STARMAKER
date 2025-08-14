package groupfortyone.group41_starmaker.Raghib;

import groupfortyone.group41_starmaker.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;

import static groupfortyone.group41_starmaker.Raghib.Query.queryList;
import static groupfortyone.group41_starmaker.Raghib.Song.songs;

public class SendQueryToCSOController {
    @javafx.fxml.FXML
    private AnchorPane querytextarea;
    @javafx.fxml.FXML
    private TextField usernametextfield;
    @javafx.fxml.FXML
    private TextArea querytextArea;
    @javafx.fxml.FXML
    private TextArea confirmationtextarea;

    @javafx.fxml.FXML
    public void initialize() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("queryinfo.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);

            } else {
                Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
                erroralert.setContentText("Bin file does not exist.");
                erroralert.show();
            }
            if (fis != null) {
                ois = new ObjectInputStream(fis);
            }
            while (true) {
                queryList.add((String) ois.readObject());
            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception e2) {
            }
        }
    }

    @javafx.fxml.FXML
    public void gobackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/SingerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Singer Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void sendOnAction(ActionEvent actionEvent) {
        if ((usernametextfield.getText().isEmpty()) && (querytextArea.getText().isEmpty())) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("Fillup the username and query");
            erroralert.show();
            return;
        }

        if (usernametextfield.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("FIllup the username");
            erroralert.show();
            return;
        }
        if (querytextArea.getText().isEmpty()) {
            Alert erroralert = new Alert(Alert.AlertType.INFORMATION);
            erroralert.setContentText("FIllup the query");
            erroralert.show();
            return;
        }
        queryList.add(usernametextfield.getText());
        queryList.add(querytextArea.getText());
        confirmationtextarea.setText("Query has been sent successfully!");
        confirmationtextarea.setStyle("-fx-background-color: Green");

        usernametextfield.clear();
        querytextArea.clear();
    }

    @javafx.fxml.FXML
    public void writeinbinfileOnAction(ActionEvent actionEvent) {
        try {
            File f = new File("queryinfo.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos);
            }
            for (String q : queryList) {
                oos.writeObject(q);
            }
            oos.close();
        } catch (Exception e) {

        }
    }
}