package userInterface;
import com.pharmacy.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class LoginController {

    @FXML
    private PasswordField adminPassword;
    @FXML
    private TextField adminUserName;
    @FXML
    private Text test;
    JSONArray jsonArray = new JSONArray();
    @FXML
    void onLoginButtonClick(ActionEvent event) {

        JSONArray jsonArray = new JSONArray();

        Object ob = null;
        JSONParser jp = new JSONParser();
        try{
            FileReader file = new FileReader("User.json");
            ob= jp.parse(file);
            file.close();
            jsonArray = (JSONArray) ob;
        } catch (IOException | ParseException e) {throw new RuntimeException(e);}

        JSONObject obj  = new JSONObject();
        int size = jsonArray.size();
        obj.put("Username",adminUserName.getText());
        obj.put("Password",adminPassword.getText());
        for (int i = 0; i < size; i++) {
            if(obj.equals(jsonArray.get(i))){
                System.out.println("It matched you poco loco");
                break;
            }else if(i== size-1){
                System.out.println("Puta nooooo");
            }
        }

    }
    @FXML
    void onRegisterButtonClick(ActionEvent event) {
        JSONObject obj  = new JSONObject();
        obj.put("Username",adminUserName.getText());
        obj.put("Password",adminPassword.getText());
        jsonArray.add(obj);
        try{
            File f = new File("User.json");
            if(!f.exists()){
                FileWriter file = new FileWriter("User.json");
                file.write(jsonArray.toJSONString());
                file.close();
            }else{
                JSONParser jsonParser = new JSONParser();
                Object object = jsonParser.parse(new FileReader("User.json"));
                JSONArray jsonArray1 = (JSONArray) object;
                jsonArray1.add(obj);
                FileWriter file = new FileWriter("User.json");
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
}
