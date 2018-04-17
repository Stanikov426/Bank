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
import sample.model.main.Main;

import java.io.IOException;


public class logController {
    private final String testLogin = "stanikov";
    private final String pass = "123456";
    private Stage stage;

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
        System.out.println(x);
        Account konto = Main.test.LogInCheck(x, passy.getText());
        if(konto!=null){
            stage = (Stage) loginButton.getScene().getWindow();
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/accountPane.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
