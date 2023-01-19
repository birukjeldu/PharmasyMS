package userInterface;
import org.json.simple.JSONObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private PasswordField adminPassword;

    @FXML
    private TextField adminUserName;


    @FXML
    private Text test;
    @FXML
    void onLoginButtonClick(ActionEvent event) {
        System.out.println("Username = "+ adminUserName.getText());
        System.out.println("Password = "+ adminPassword.getText());
        test.setText(adminUserName.getText());
        JSONObject emps = new JSONObject();
    }

}
