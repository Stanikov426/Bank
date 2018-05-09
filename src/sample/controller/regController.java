package sample.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.model.bankClass.Adres;
import sample.model.bankClass.KlientPrywatny;
import sample.model.bankClass.Kontakt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.model.main.Main.*;

public class regController implements Initializable {
    private Stage stage;

    @FXML
    private Button regButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField age;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private TextField zipcode;

    @FXML
    private TextField city;

    @FXML
    private TextField adress;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        back();
    }

    @FXML
    void regClick(ActionEvent event) throws IOException {
        if(checkTextField()){
            Kontakt contact;
            try{
                contact = new Kontakt(Integer.valueOf(phone.getText()), email.getText());
            }catch(NumberFormatException error){
                showError("Something is wrong with phone number");
                return;
            }
            Adres newAdress = new Adres(city.getText(), adress.getText(), zipcode.getText());

            try {
                int idNumber = randomId();
                while(idNumber==0){
                    idNumber = randomId();
                }
                KlientPrywatny newClient = new KlientPrywatny(idNumber, name.getText(), surname.getText(), Integer.valueOf(age.getText()));
                newClient.dodajKontakt(contact);
                newClient.dodajAdres(newAdress);
                addPrivClient(newClient);
            }catch (NumberFormatException error){
                showError("Not correct value of age");
                return;
            }

            back();
        }
        else{
            showError("Fill all informations");
        }
    }
    private void back() throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/clientPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!!!");
        alert.setHeaderText("Something is wrong");
        alert.setContentText(message);

        alert.showAndWait();
    }
    private Boolean checkTextField(){
        if(name.getText().equals("")||surname.getText().equals("")||age.getText().equals("")||phone.getText().equals("")||
                email.getText().equals("")||zipcode.getText().equals("")||adress.getText().equals("")||city.getText().equals("")){
            return false;
        }
        else {
            return true;
        }
    }
}
