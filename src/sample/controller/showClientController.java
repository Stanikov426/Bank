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
import sample.model.bankClass.KlientFirmowy;
import sample.model.bankClass.KlientPrywatny;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static sample.controller.clientController.pomId;
import static sample.model.main.Main.*;

public class showClientController implements Initializable {
    private Stage stage;
    public static KlientPrywatny pomClient;
    public static KlientFirmowy pomCompany;

    @FXML
    private Label infoLabel;

    @FXML
    private Button backButton;

    @FXML
    private Label adresLabel;

    @FXML
    private Label contactLabel;


    @FXML
    void addAccClick(ActionEvent event) throws IOException {
        openPane("/sample/view/addAccPane.fxml");
    }

    @FXML
    void backClick(ActionEvent event) throws IOException {
        openPane("/sample/view/clientPane.fxml");
    }

    @FXML
    void delAccClick(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Delete account");
        dialog.setHeaderText("Delete account by acc number");
        dialog.setContentText("Please acc number:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            if(pomClient!=null){
                pomClient.deleteAccByNumber(result.get());
            }
            else{
                pomCompany.deleteAccByNumber(result.get());
            }
        }
    }

    @FXML
    void showOperationsClick(ActionEvent event) throws IOException {
        openPane("/sample/view/clientOperationsPane.fxml");
    }

    @FXML
    void editContactClick(ActionEvent event) throws IOException {
        openPane("/sample/view/editContactPane.fxml");
    }

    @FXML
    void showAllClick(ActionEvent event) throws IOException {
        openPane("/sample/view/showAccPane.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pomClient = getPrivClientById(pomId);
        pomCompany = getCompanyById(pomId);
        if(pomClient!=null){
            infoLabel.setText(pomClient.info());
            adresLabel.setText(pomClient.getAdressInfo());
            contactLabel.setText(pomClient.getContactInfo());
        }
        else{
            infoLabel.setText(pomCompany.info());
            adresLabel.setText(pomCompany.getAdressInfo());
            contactLabel.setText(pomCompany.getContactInfo());
        }
    }
    private void openPane(String paneAdress) throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource(paneAdress));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
