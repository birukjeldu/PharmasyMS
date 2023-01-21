package userInterface;

import com.pharmacy.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchScene {
    @FXML
    private Button button;
    @FXML
    private Button logout;

    @FXML
    void addMedicinePage(ActionEvent event) throws IOException {
        Stage stage = (Stage)button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Add-Medicine.fxml"));
        Scene root = new Scene(fxmlLoader.load());
        stage.setTitle("Add Medicine");
        stage.setScene(root);

    }

    @FXML
    void listMedicinePage(ActionEvent event) throws IOException {
        Stage stage = (Stage)button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("List-Medicine.fxml"));
        Scene root = new Scene(fxmlLoader.load());
        stage.setTitle("List Of Medicine");
        stage.setScene(root);
    }

    @FXML
    void salePage(ActionEvent event) {

    }

    @FXML
    void storePage(ActionEvent event) throws IOException {
        Stage stage = (Stage)button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Store.fxml"));
        Scene root = new Scene(fxmlLoader.load());
        stage.setTitle("Store");
        stage.setScene(root);
    }

    @FXML
    void transactionPage(ActionEvent event) throws IOException {
        Stage stage = (Stage)button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Transaction.fxml"));
        Scene root = new Scene(fxmlLoader.load());
        stage.setTitle("Transaction");
        stage.setScene(root);
    }

    @FXML
    void employePage(ActionEvent event) throws IOException {
        Stage stage = (Stage)button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Employee.fxml"));
        Scene root = new Scene(fxmlLoader.load());
        stage.setTitle("Transaction");
        stage.setScene(root);
    }

    @FXML
    void loginPage(ActionEvent event) throws IOException {
        Stage stage = (Stage)button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene root = new Scene(fxmlLoader.load());
        stage.setTitle("Transaction");
        stage.setScene(root);
    }
}
