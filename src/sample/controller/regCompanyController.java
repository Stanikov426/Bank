package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.bankClass.Adres;
import sample.model.bankClass.KlientFirmowy;
import sample.model.bankClass.Kontakt;

import java.io.IOException;

import static sample.model.main.Main.*;
import static sample.model.main.Main.randomId;

public class regCompanyController {
    private Stage stage;

    @FXML
    private Button regButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField companyName;

    @FXML
    private TextField nip;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private TextField adress;

    @FXML
    private TextField city;

    @FXML
    private TextField zipcode;

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

            try{
                int idNumber = randomId();
                while(idNumber==0){
                    idNumber = randomId();
                }
                KlientFirmowy newClient = new KlientFirmowy(idNumber, companyName.getText(), Integer.valueOf(nip.getText()));
                newClient.dodajKontakt(contact);
                newClient.dodajAdres(newAdress);
                addCompanyClient(newClient);
            }catch (NumberFormatException error){
                showError("Not correct value of nip");
                return;
            }
            back();
        }
        else {
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
    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!!!");
        alert.setHeaderText("Something is wrong");
        alert.setContentText(message);

        alert.showAndWait();
    }
    private Boolean checkTextField(){
        if(companyName.getText().equals("")||nip.getText().equals("")||phone.getText().equals("")||
                email.getText().equals("")||zipcode.getText().equals("")||adress.getText().equals("")||city.getText().equals("")){
            return false;
        }
        else {
            return true;
        }
    }
}
