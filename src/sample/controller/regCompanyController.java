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
import sample.model.bankClass.KlientFirmowy;
import sample.model.bankClass.KlientPrywatny;
import sample.model.bankClass.Kontakt;

import java.io.IOException;

import static sample.model.main.Main.addCompanyClient;
import static sample.model.main.Main.addPrivClient;
import static sample.model.main.Main.idCounter;

public class regCompanyController {
    private Stage stage;

    @FXML
    private Button regButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField comapnyName;

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
        Kontakt contact = new Kontakt(Integer.valueOf(phone.getText()), email.getText());
        Adres newAdress = new Adres(city.getText(), adress.getText(), zipcode.getText());

        KlientFirmowy newClient = new KlientFirmowy(idCounter, comapnyName.getText(), Integer.valueOf(nip.getText()));
        newClient.dodajKontakt(contact);
        newClient.dodajAdres(newAdress);
        addCompanyClient(newClient);
        idCounter++;
        back();
    }
    private void back() throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/clientPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
