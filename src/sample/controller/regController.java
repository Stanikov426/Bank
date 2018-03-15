package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static sample.model.main.Main.test;

public class regController {
    @FXML
    private TextField login;

    @FXML
    private PasswordField passy;

    @FXML
    private Button regButton;

    @FXML
    void regClick(ActionEvent event) {
        test.createBankAccount();
    }
}
