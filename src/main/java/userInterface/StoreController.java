package userInterface;

import com.pharmacy.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreController extends SwitchScene {
    @FXML
    private TextField storeAddress;
    @FXML
    private TextField storeName;


    @FXML
    void addStore(ActionEvent event) {
        //Store Name validation
        if (Validator.isOnlyString(storeName,storeName.getText()) && Validator.isValidString(storeName,storeName.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }

        //Store Address validation
        if (Validator.isOnlyString(storeAddress,storeAddress.getText()) && Validator.isValidString(storeAddress,storeAddress.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }
    }
}
