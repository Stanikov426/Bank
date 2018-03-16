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
import sample.model.bank.Person;
import sample.model.main.Main;

import java.io.IOException;

public class regController {
    private Stage stage;

    @FXML
    private TextField surname;

    @FXML
    private PasswordField password;

    @FXML
    private Button regButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private TextField id;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        back();
    }

    @FXML
    void regClick(ActionEvent event) throws IOException {
        Person person = new Person(name.getText(),surname.getText(), Integer.valueOf(age.getText()));
        Account account = new Account(Integer.valueOf(id.getText()), password.getText(), person);
        Main.test.addAccount(account);
        back();
    }
    private  void back() throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/mainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
