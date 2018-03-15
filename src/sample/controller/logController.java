package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static sample.model.main.Main.test;


public class logController {
    private final String testLogin = "stanikov";
    private final String pass = "123456";

    @FXML
    private TextField login;

    @FXML
    private PasswordField passy;

    @FXML
    private Button loginButton;

    @FXML
    void loginClick(ActionEvent event) {

    }
}
