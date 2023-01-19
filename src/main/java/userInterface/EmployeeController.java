package userInterface;

import com.pharmacy.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import userInterface.Validator;

public class EmployeeController extends SwitchScene {

    // end of

    @FXML
    private TextField address;
    @FXML
    private TextField fullName;
    @FXML
    private PasswordField password;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField salary;
    @FXML
    private TextField userName;

    @FXML
    void addEmployeeButton(ActionEvent event) {
        //User Name validation
        if (Validator.isOnlyStringNoSpace(userName,userName.getText()) && Validator.isValidString(userName,userName.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }

        //Full Name validation
        if (Validator.isOnlyString(fullName,fullName.getText()) && Validator.isValidString(fullName,fullName.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }

        //Address validation
        if (Validator.isOnlyString(address,address.getText()) && Validator.isValidString(address,address.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }

        //Password validation
        if (Validator.isValidString(password,password.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }

        //Salary validation
        if (Validator.isValidFloat(salary,salary.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }

        //Phone number validation
        if (Validator.isValidPhoneNumber(phoneNumber,phoneNumber.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }
    }

}
