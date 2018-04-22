package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.bankClass.Adres;
import sample.model.bankClass.Kontakt;

import java.io.IOException;

import static sample.controller.showClientController.pomClient;
import static sample.controller.showClientController.pomCompany;

public class editContactController {
    private Stage stage;
    private Adres pomAdres;
    private Kontakt pomContact;

    @FXML
    private TextField adress;

    @FXML
    private TextField city;

    @FXML
    private TextField zipcode;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        back();
    }

    @FXML
    void saveClick(ActionEvent event) throws IOException {
        if(pomClient!=null){
            editClientContact();
        }
        else{
            editCompanyContact();
        }
        back();
    }
    private void editClientContact(){
        pomAdres = pomClient.getAdress();
        pomContact = pomClient.getContact();
        if(!email.getText().equals("")){
            pomContact.setEmail(email.getText());
        }
        if(!phone.getText().equals("")){
            pomContact.setNrTel(Integer.valueOf(phone.getText()));
        }
        if(!adress.getText().equals("")){
            pomAdres.setAdress(adress.getText());
        }
        if(!city.getText().equals("")){
            pomAdres.setMiasto(city.getText());
        }
        if(!zipcode.getText().equals("")){
            pomAdres.setKodPocztowy(zipcode.getText());
        }
        pomClient.dodajAdres(pomAdres);
        pomClient.dodajKontakt(pomContact);
    }
    private void editCompanyContact(){
        pomAdres = pomCompany.getAdress();
        pomContact = pomCompany.getContact();
        if(!email.getText().equals("")){
            pomContact.setEmail(email.getText());
        }
        if(!phone.getText().equals("")){
            pomContact.setNrTel(Integer.valueOf(phone.getText()));
        }
        if(!adress.getText().equals("")){
            pomAdres.setAdress(adress.getText());
        }
        if(!city.getText().equals("")){
            pomAdres.setMiasto(city.getText());
        }
        if(!zipcode.getText().equals("")){
            pomAdres.setKodPocztowy(zipcode.getText());
        }
        pomCompany.dodajAdres(pomAdres);
        pomCompany.dodajKontakt(pomContact);
    }
    private void back() throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/showClientPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

