package userInterface;

import com.pharmacy.HelloApplication;
import com.pharmacy.Supplier;
import com.pharmacy.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreController extends SwitchScene implements Initializable {
    @FXML
    private String pfName;

    @FXML
    private Text profileName;
    @FXML
    private Button button;

    @FXML
    private TextField supAddress;

    @FXML
    private TableColumn<Supplier, String> supAddressColumn;

    @FXML
    private TextField supEmail;

    @FXML
    private TableColumn<Supplier, String> supEmailColumn;

    @FXML
    private TableColumn<Supplier, Integer> supIdColumn;

    @FXML
    private TextField supName;

    @FXML
    private TableColumn<Supplier, String> supNameColumn;

    @FXML
    private TextField supPhone;

    @FXML
    private TableColumn<Supplier, String> supPhoneColumn;

    @FXML
    private TableView<Supplier> suppllierTable;
    Supplier supplier = new Supplier();


    ObservableList<Transaction> list = FXCollections.observableArrayList(

    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        supPhoneColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("phoneNumber"));
        supNameColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("name"));
        supEmailColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("email"));
        supIdColumn.setCellValueFactory(new PropertyValueFactory<Supplier,Integer>("id"));
        supAddressColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("address"));
        String pfName = "@" + LoginController.getProfName();
        profileName.setText(pfName);
        //transTable.setItems(list);
        File f = new File("Supplier.json");
        if(f.exists()){
            try {
                readFromJson();
            } catch (IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        }


    }
    public void readFromJson() throws IOException, ParseException {
        Supplier.count = 0;
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader("Supplier.json"));
        JSONArray jsonArray1 = (JSONArray) object;
        JSONObject obj  = new JSONObject();
        int size = jsonArray1.size();
        for (int i = 0; i < size; i++) {
            Supplier sup = new Supplier();
            JSONObject tes = (JSONObject) jsonArray1.get(i);
            sup.setAddress(tes.get("SupplierAddress").toString());
            sup.setEmail(tes.get("SupplierEmail").toString());
            sup.setName(tes.get("SupplierName").toString());
            sup.setPhoneNumber(tes.get("SupplierPhone").toString());

            suppllierTable.getItems().add(sup);
            System.out.println("-------------------------------");

        }

    }


    public void writeToJsonfile(){
        JSONObject obj  = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        obj.put("SupplierAddress",supplier.getAddress());
        obj.put("SupplierName",supplier.getName());
        obj.put("SupplierEmail",supplier.getEmail());
        obj.put("SupplierPhone",supplier.getPhoneNumber());
        obj.put("SupplierId",supplier.getId());
        jsonArray.add(obj);
        try{
            File f = new File("Supplier.json");
            if(!f.exists()){
                FileWriter file = new FileWriter("Supplier.json");
                file.write(jsonArray.toJSONString());
                file.close();
            }else{
                JSONParser jsonParser = new JSONParser();
                Object object = jsonParser.parse(new FileReader("Supplier.json"));
                JSONArray jsonArray1 = (JSONArray) object;
                jsonArray1.add(obj);
                FileWriter file = new FileWriter("Supplier.json");
                file.write(jsonArray1.toJSONString());
                file.flush();
                file.close();
            }

        }catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonArray);
    }


    @FXML
    void AddSupplierButton(ActionEvent event) {
        boolean supNameValid,supAddressValid,supEmailValid,supPhoneValid = false;
        //Supplier name validation
        if (Validator.isValidString(supName,supName.getText())){
            supplier.setName(supName.getText());
            supNameValid = true;
            System.out.println("yea it is validd");
        }else {
            supNameValid = false;
            System.out.println("nooo");
        }
        //Supplier Address validation
        if (Validator.isValidString(supAddress,supAddress.getText())){
            supplier.setAddress(supAddress.getText());
            supAddressValid = true;
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo");
            supAddressValid = false;
        }
        //Supplier Email validation
        if (Validator.isValidString(supEmail,supEmail.getText())){
            supplier.setEmail(supEmail.getText());
            supEmailValid = true;
            System.out.println("yea it is validd");
        }else {
            supEmailValid = false;
            System.out.println("nooo");
        }
        //Supplier Phone validation
        if (Validator.isValidPhoneNumber(supPhone,supPhone.getText())){
            supplier.setPhoneNumber(supPhone.getText());
            supPhoneValid = true;
            System.out.println("yea it is validd");
        }else {
            supPhoneValid = false;
            System.out.println("nooo");
        }

        boolean allValid = supNameValid && supAddressValid && supEmailValid && supPhoneValid;
        if(allValid){
            //succesMessge.setText("Successfully Added An Drug");
            //employeeTable.getItems().add(employee);
            supName.setText("");
            supName.setStyle("-fx-border-color: ");
            supAddress.setText("");
            supAddress.setStyle("-fx-border-color: ");
            supEmail.setText("");
            supEmail.setStyle("-fx-border-color: ");
            supPhone.setText("");
            supPhone.setStyle("-fx-border-color: ");

            writeToJsonfile();
            Stage stage = (Stage)button.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Store.fxml"));
            Scene root = null;
            try {
                root = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Supplier");
            stage.setResizable(false);
            stage.setScene(root);
        }
    }
}
