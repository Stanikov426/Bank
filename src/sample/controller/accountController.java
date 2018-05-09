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
import sample.model.bankClass.Klient;
import sample.model.bankClass.Konto;
import sample.model.bankClass.Operacja;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import static sample.controller.logController.getLogAcc;
import static sample.controller.logController.getLogClient;

public class accountController implements Initializable {
    private Stage stage;
    private Konto pomAcc;
    private Klient pomClient;

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
    void accOperationsClick(ActionEvent event) throws IOException {
        stage = (Stage) logoutButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/accountOperationsPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void transferClick(ActionEvent event) throws IOException {
        stage = (Stage) logoutButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/transferPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void depoClick(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Deposit your money!");
        dialog.setHeaderText("How much money do u wanna deposit");
        dialog.setContentText("Please enter money:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            pomAcc.depositCash(Double.valueOf(result.get()));
            refreshCashLabel();
        }
        Date date = new Date();
        Operacja newOperation = new Operacja(pomAcc,pomAcc, date, "Deposit "+Double.valueOf(result.get())+" money");
        pomAcc.dodajOperacje(newOperation);
        pomClient.dodajOperacje(newOperation);
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
            if(pomAcc.withdrawCash(Double.valueOf(result.get().toString()))){
                Date date = new Date();
                Operacja newOperation = new Operacja(pomAcc, pomAcc, date, "Withdraw "+Double.valueOf(result.get())+" money");
                pomAcc.dodajOperacje(newOperation);
                pomClient.dodajOperacje(newOperation);
            }
            refreshCashLabel();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pomAcc = getLogAcc();
        pomClient = getLogClient();
        userLabel.setText("The owner of account is client id: " + pomClient.getId());
        refreshCashLabel();
    }
    private void refreshCashLabel(){
        cashLabel.setText("Cash on your account: " + Double.valueOf(pomAcc.getSrodki())+pomAcc.getCurrency());
    }
}