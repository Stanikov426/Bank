package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.model.bankClass.Konto;
import sample.model.bankClass.KontoOszczednosciowe;
import sample.model.bankClass.KontoWalutowe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.controller.showClientController.pomClient;
import static sample.controller.showClientController.pomCompany;
import static sample.model.main.Main.getAccByNumber;

public class addAccController implements Initializable {
    private Stage stage;
    private Konto newAcc;

    @FXML
    private Button regButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField accNumber;

    @FXML
    private TextField startCash;

    @FXML
    private ChoiceBox<String> accountType;

    @FXML
    private PasswordField password;

    @FXML
    private ChoiceBox<String> currencyOfCash;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        back();
    }

    @FXML
    void regClick(ActionEvent event) throws IOException {
        if(checkTextField()){
            if(accountType.getValue().equals("Standard")){
                try{
                    if(checkAccNumber(Integer.valueOf(accNumber.getText()))){
                        newAcc = new Konto(Integer.valueOf(accNumber.getText()), password.getText(), Double.valueOf(startCash.getText()));
                        pomClient.dodajKonto(newAcc);
                    }else{
                        showError("This account number is busy");
                        return;
                    }
                }catch (NumberFormatException error){
                    showError("Bad type of account number or nip");
                    return;
                }
            }
            else if(accountType.getValue().equals("For Young")){

            }
            else if(accountType.getValue().equals("Savings")){
                newAcc = new KontoOszczednosciowe(Integer.valueOf(accNumber.getText()), password.getText(), Double.valueOf(startCash.getText()));
                pomClient.dodajKonto(newAcc);
            }
            else if(accountType.getValue().equals("Currency")){
                newAcc = new KontoWalutowe(Integer.valueOf(accNumber.getText()), password.getText(), Double.valueOf(startCash.getText()), currencyOfCash.getValue());
                pomClient.dodajKonto(newAcc);
            }
            else if(accountType.getValue().equals("Standard Company")){
                newAcc = new Konto(Integer.valueOf(accNumber.getText()), password.getText(), Double.valueOf(startCash.getText()));
                pomCompany.dodajKonto(newAcc);
            }
            else{
                showError("Wrong account type");
            }
        }else{
            showError("Fill all informations");
        }
        back();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(pomClient!=null){
            accountType.getItems().addAll("Standard", "For Young", "Savings", "Currency");
            currencyOfCash.getItems().addAll("PLN", "EUR", "USD","GBP", "RUB", "JPY", "SEK");
            currencyOfCash.setValue("PLN");
            accountType.setValue("Standard");
        }
        else{
            accountType.getItems().addAll("Standard Company");
            accountType.setValue("Standard Company");
        }
    }

    private void back() throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/showClientPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private Boolean checkTextField(){
        if(accNumber.getText().equals("")||password.getText().equals("")||startCash.getText().equals("")){
            return false;
        }
        else {
            return true;
        }
    }
    private Boolean checkAccNumber(int accNumber){
        if(getAccByNumber(accNumber)==null){
            return true;
        }
        else{
            return false;
        }
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!!!");
        alert.setHeaderText("Something is wrong");
        alert.setContentText(message);

        alert.showAndWait();
    }
}
