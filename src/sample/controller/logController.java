package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.bank.Account;
import sample.model.bankClass.Klient;
import sample.model.bankClass.Konto;
import sample.model.main.Main;

import java.io.IOException;

import static sample.model.main.Main.loginAcc;
import static sample.model.main.Main.loginClient;


public class logController {
    private Stage stage;
    private static Konto logAcc;
    private static Klient logClient;

    @FXML
    private TextField login;

    @FXML
    private PasswordField passy;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/mainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginClick(ActionEvent event) throws IOException {
        int x = Integer.valueOf(login.getText());
        logAcc = loginAcc(x, passy.getText());
        if(logAcc!=null){
            logClient = loginClient(x, passy.getText());
            stage = (Stage) loginButton.getScene().getWindow();
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/accountPane.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public static Konto getLogAcc() {
        return logAcc;
    }

    public static Klient getLogClient() {
        return logClient;
    }
}
