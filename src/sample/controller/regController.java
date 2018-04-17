package sample.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.bank.Account;
import sample.model.bank.Person;
import sample.model.bankClass.Adres;
import sample.model.bankClass.KlientPrywatny;
import sample.model.bankClass.Kontakt;
import sample.model.main.Main;

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
    private ChoiceBox<String> accountType;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        back();
    }

    @FXML
    void regClick(ActionEvent event) throws IOException {
        Kontakt contact = new Kontakt(Integer.valueOf(phone.getText()), email.getText());
        Adres newAdress = new Adres(city.getText(), adress.getText(), zipcode.getText());

        KlientPrywatny newClient = new KlientPrywatny(1, name.getText(), surname.getText(), Integer.valueOf(age.getText()));
        newClient.dodajKontakt(contact);
        newClient.dodajAdres(newAdress);
        addPrivClient(newClient);
        //Person person = new Person(name.getText(),surname.getText(), Integer.valueOf(age.getText()));
        //Account account = new Account(Integer.valueOf(id.getText()), password.getText(), person);
        //Main.test.addAccount(account);
        back();
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
        accountType.getItems().addAll("Standard", "For Young", "Savings", "Currency");
    }
}
