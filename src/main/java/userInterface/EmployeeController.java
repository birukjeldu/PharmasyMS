package userInterface;

import com.pharmacy.Employee;
import com.pharmacy.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import userInterface.Validator;

public class EmployeeController extends SwitchScene implements Initializable {

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
    private TextField email;
    @FXML
    private TextField salary;
    @FXML
    private TextField userName;

    @FXML
    private Label succesMessge;
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> usrNameColumn;
    @FXML
    private TableColumn<Employee, String> addressColumn;
    @FXML
    private TableColumn<Employee, String> phoneColumn;
    @FXML
    private TableColumn<Employee, Double> salaryColumn;
    @FXML
    private TableColumn<Employee, String> emailColumn;
    @FXML
    private TableColumn<Employee, String> passColumn;
    ObservableList<Employee> list = FXCollections.observableArrayList(

    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("fullName"));
        usrNameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("userName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("email"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("phoneNumber"));
        passColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("password"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee,Double>("salary"));
        employeeTable.setItems(list);
        File f = new File("Employee.json");
        if(f.exists()){
            try {
                readFromJson();
            } catch (IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        }


    }
    Employee employee = new Employee();
    //To add an employee account
    @FXML
    void addEmployeeButton(ActionEvent event) throws IOException, ParseException {


        employee.setSex('M');

        boolean usrNameValid,fulNameValid,emailValid,passValid,addressValid,salValid,phoneValid = false;

        //User Name validation
        if (Validator.isOnlyStringNoSpace(userName,userName.getText()) && Validator.isValidString(userName,userName.getText())){
            employee.setUserName(userName.getText());
            usrNameValid = true;
            System.out.println("yea it is validd");
        }else {
            System.out.println("nooo");
            usrNameValid = false;
        }

        //Full Name validation
        if (Validator.isOnlyString(fullName,fullName.getText()) && Validator.isValidString(fullName,fullName.getText())){
            employee.setFullName(fullName.getText());
            fulNameValid = true;
            System.out.println("yea it is validd");
        }else {
            fulNameValid = false;
            System.out.println("nooo");
        }

        //Address validation
        if (Validator.isOnlyString(address,address.getText()) && Validator.isValidString(address,address.getText())){
            employee.setAddress(address.getText());
            addressValid = true;
            System.out.println("yea it is validd");
        }else {
            addressValid = false;
            System.out.println("nooo");
        }

        //Password validation
        if (Validator.isValidString(password,password.getText())){
            employee.setPassword(password.getText());
            passValid = true;
            System.out.println("yea it is validd");
        }else {
            passValid = false;
            System.out.println("nooo");
        }
        //Email validation
        if (Validator.isValidString(email,email.getText())){
            employee.setEmail(email.getText());
            emailValid = true;
            System.out.println("yea it is validd");
        }else {
            emailValid = false;
            System.out.println("nooo ");
        }

        //Salary validation
        if (Validator.isValidFloat(salary,salary.getText())){
            double sal = Double.parseDouble(salary.getText());
            employee.setSalary(sal);
            salValid = true;
            System.out.println("yea it is validd");
        }else {
            salValid = false;
            System.out.println("nooo");
        }

        //Phone number validation
        if (Validator.isValidPhoneNumber(phoneNumber,phoneNumber.getText())){
            employee.setPhoneNumber(phoneNumber.getText());
            phoneValid = true;
            System.out.println("yea it is validd");
        }else {
            phoneValid = false;
            System.out.println("nooo");
        }
        boolean allValid = usrNameValid && fulNameValid && emailValid && passValid && addressValid && salValid && phoneValid;
        if(allValid){
            //succesMessge.setText("Successfully Added An Employee");
            employeeTable.getItems().add(employee);
            address.setText("");
            address.setStyle("-fx-border-color: ");
            fullName.setText("");
            fullName.setStyle("-fx-border-color: ");
            password.setText("");
            password.setStyle("-fx-border-color: ");
            phoneNumber.setText("");
            phoneNumber.setStyle("-fx-border-color: ");
            email.setText("");
            email.setStyle("-fx-border-color: ");
            salary.setText("");
            salary.setStyle("-fx-border-color: ");
            userName.setText("");
            userName.setStyle("-fx-border-color: ");
            writeToJsonfile();


        }
    }
    public void writeToJsonfile(){
        JSONObject obj  = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        obj.put("Username",employee.getUserName());
        obj.put("Password",employee.getPassword());
        obj.put("FullName",employee.getFullName());
        obj.put("Address",employee.getAddress());
        obj.put("Email",employee.getEmail());
        obj.put("Salary",employee.getSalary());
        obj.put("PhoneNumber",employee.getPhoneNumber());
        jsonArray.add(obj);
        try{
            File f = new File("Employee.json");
            if(!f.exists()){
                FileWriter file = new FileWriter("Employee.json");
                file.write(jsonArray.toJSONString());
                file.close();
            }else{
                JSONParser jsonParser = new JSONParser();
                Object object = jsonParser.parse(new FileReader("Employee.json"));
                JSONArray jsonArray1 = (JSONArray) object;
                jsonArray1.add(obj);
                FileWriter file = new FileWriter("Employee.json");
                file.write(jsonArray1.toJSONString());
                file.flush();
                file.close();
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonArray);
    }

    //To read the Employee list from the json and displaying it to the table
    public void readFromJson() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader("Employee.json"));
        JSONArray jsonArray1 = (JSONArray) object;
        JSONObject obj  = new JSONObject();
        int size = jsonArray1.size();
        for (int i = 0; i < size; i++) {
            Employee emp = new Employee();
            JSONObject tes = (JSONObject) jsonArray1.get(i);
            System.out.println(tes.get("Salary"));
            emp.setSalary(Double.parseDouble(tes.get("Salary").toString()));
            System.out.println(tes.get("Email"));
            emp.setEmail(tes.get("Email").toString());
            System.out.println(tes.get("Address"));
            emp.setAddress(tes.get("Address").toString());
            System.out.println(tes.get("Username"));
            emp.setUserName(tes.get("Username").toString());
            System.out.println(tes.get("FullName"));
            emp.setFullName(tes.get("FullName").toString());
            System.out.println(tes.get("PhoneNumber"));
            emp.setPhoneNumber(tes.get("PhoneNumber").toString());
            System.out.println(tes.get("Password"));
            emp.setPassword(tes.get("Password").toString());
            employeeTable.getItems().add(emp);
            System.out.println("-------------------------------");

        }

    }

}


