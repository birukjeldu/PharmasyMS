package userInterface;

import com.pharmacy.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.cert.CertPathValidatorResult;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import userInterface.Validator;

public class addMedicineController extends SwitchScene {

    @FXML
    private DatePicker expDate;
    @FXML
    private TextField manuName;
    //@FXML
    //private Button medAddButton;
    @FXML
    private TextField medAmount;
    @FXML
    private TextArea medDescription;
    @FXML
    private TextField medName;
    @FXML
    private TextField medPrice;
    @FXML
    private Label priceError;
    @FXML
    private Label amountError;


    @FXML
    void addMedicine(ActionEvent event) {
        //Medicine name validation
        if (Validator.isValidString(medName,medName.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }
        //Manufacture name validation
        if (Validator.isValidString(manuName,manuName.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }
        //Description validation
        if (Validator.isValidString(medDescription,medDescription.getText())){
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo bitch");
        }
        //Amount Validation
        if (Validator.isValidInt(medAmount,medAmount.getText())){
            System.out.println("yea it is validd");
            amountError.setText("");
        }else {
            System.out.println("nooo bitch");
            amountError.setText("Only integer Numbers allowed");
        }
        //Price Validation
        if (Validator.isValidFloat(medPrice,medPrice.getText())){
            System.out.println("yea it is validd");
            priceError.setText("");
        }else {
            System.out.println("nooo bitch");
            priceError.setText("Only Numbers allowed");
        }
        //Expire Date validation
        LocalDate exDate = expDate.getValue();
        String formatedDate = exDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
        System.out.println(formatedDate);
    }

}
