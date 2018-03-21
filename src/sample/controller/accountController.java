package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import sample.model.bank.Account;
import sample.model.bank.Person;
import sample.model.main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static sample.model.main.Main.test;

public class accountController implements Initializable {
    private Account pom;
    private Stage stage;

    @FXML
    private Button depoButton;

    @FXML
    private Button withdrawButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Label userLabel;

    @FXML
    private Label cashLabel;

    @FXML
    private Button transferButton;

    @FXML
    void transferClick(ActionEvent event) {

    }

    @FXML
    void depoClick(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Deposit your money!");
        dialog.setHeaderText("How much money do u wanna deposit");
        dialog.setContentText("Please enter money:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            pom.addCash(Integer.valueOf(result.get().toString()));
            test.edit(pom);
            cashLabel.setText(Integer.valueOf(pom.getCash()).toString());
        }
    }

    @FXML
    void logoutClick(ActionEvent event) throws IOException {
        stage = (Stage) logoutButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/mainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void withdrawClick(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Withdraw your money!");
        dialog.setHeaderText("How much money do u wanna withdraw");
        dialog.setContentText("Please enter money:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            pom.removeCash(Integer.valueOf(result.get().toString()));
            test.edit(pom);
            cashLabel.setText(Integer.valueOf(pom.getCash()).toString());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pom = test.getAccount();
        Person pomPerson = pom.getPerson();
        userLabel.setText("Name: " + pomPerson.getName() + " Surname: " + pomPerson.getSurname() + " Age: " + pomPerson.getAge());
        cashLabel.setText("Cash: " + Integer.valueOf(pom.getCash()).toString());
    }

}