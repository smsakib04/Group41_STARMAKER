package groupfortyone.group41_starmaker;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private PasswordField passwordTextField;
    @javafx.fxml.FXML
    private Label loginLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) {
        if ((idTextField.getText().equals("00001")) && (passwordTextField.getText().equals("12345"))){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Salman/CEO_Dashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("CEO Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            loginLabel.setText("Login Successful");
        } else if ((idTextField.getText().equals("00002")) && (passwordTextField.getText().equals("12345"))) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Salman/CSO_Dashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Customer Service Officer Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            loginLabel.setText("Login Successful");
        }
        else {
            loginLabel.setText("ID or Password is incorrect!");
        }
    }
}