package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.bankClass.Klient;
import sample.model.bankClass.Konto;
import sample.model.bankClass.Operacja;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import static sample.controller.logController.getLogAcc;
import static sample.controller.logController.getLogClient;
import static sample.model.main.Main.*;

public class transferController implements Initializable{
    private Stage stage;
    private Konto sendAcc;
    private Klient sendClient;
    private Konto recipientAcc;
    private Klient recipientClient;

    @FXML
    private TextField toID;

    @FXML
    private TextField sendMoney;

    @FXML
    private Button sendButton;

    @FXML
    private Button backButton;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        back();
    }

    @FXML
    void sendClick(ActionEvent event) throws IOException {
        if(getAccByNumber(Integer.valueOf(toID.getText()))!=null){
            recipientAcc = getAccByNumber(Integer.valueOf(toID.getText()));
            recipientClient = getClientByAccNumber(Integer.valueOf(toID.getText()));
            if(sendAcc.withdrawCash(Double.valueOf(sendMoney.getText()))&& !sendAcc.equals(recipientAcc) /*!sendClient.equals(recipientClient)*/){
                recipientAcc.depositCash(Double.valueOf(sendMoney.getText()));
                Date date = new Date();
                Operacja newOperation = new Operacja(sendClient, recipientClient, sendAcc, recipientAcc, date, "Transfer to "+ recipientAcc.getStringNumerKonta()+", money " +sendMoney.toString());
                sendAcc.dodajOperacje(newOperation);
                sendClient.dodajOperacje(newOperation);
                recipientAcc.dodajOperacje(newOperation);
                recipientClient.dodajOperacje(newOperation);
            }else if(sendAcc.equals(recipientAcc) ){
                showError("You can send money to same account");
            }else{
                showError("Not enough money on your account");
            }
        }
        else {
            showError("Cant find account with this number...");
        }
        back();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sendAcc = getLogAcc();
        sendClient = getLogClient();
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!!!");
        alert.setHeaderText("Something is wrong");
        alert.setContentText(message);

        alert.showAndWait();
    }

    private void back() throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/accountPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
