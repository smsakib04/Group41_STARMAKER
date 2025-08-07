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
        if((idTextField.getText().isEmpty()) && (passwordTextField.getText().isEmpty())){
            loginLabel.setText("Please give valid ID and Password");
            return;
        }
        if (idTextField.getText().isEmpty()){
            loginLabel.setText("Please give a valid ID");
            return;
        }
        if (passwordTextField.getText().isEmpty()){
            loginLabel.setText("Please give a valid Password");
            return;
        }
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
        } else if ((idTextField.getText().equals("00003")) && (passwordTextField.getText().equals("12345"))){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/HRMDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Human Resource Manager Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            loginLabel.setText("Login Successful");
        }else if ((idTextField.getText().equals("00004")) && (passwordTextField.getText().equals("12345"))){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Youshra/AccountantDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Accountant Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            loginLabel.setText("Login Successful");
        }else if ((idTextField.getText().equals("00005")) && (passwordTextField.getText().equals("12345"))){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/LiveBroadcasterDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Live Broadcaster Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            loginLabel.setText("Login Successful");
        }else if ((idTextField.getText().equals("00006")) && (passwordTextField.getText().equals("12345"))){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Samanta/ViewerDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Viewer Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            loginLabel.setText("Login Successful");
        } else if ((idTextField.getText().equals("00007")) && (passwordTextField.getText().equals("12345"))){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/SingerDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Singer Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            loginLabel.setText("Login Successful");
        }else if ((idTextField.getText().equals("00008")) && (passwordTextField.getText().equals("12345"))){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Raghib/MarketingExecutiveDashboard.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Marketing Executive Dashboard");
                nextStage.setScene(nextScene);
                nextStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            loginLabel.setText("Login Successful");
        } else {
            loginLabel.setText("Incorrect Username or Password!");
        }
    }
}