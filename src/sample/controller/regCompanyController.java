package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class regCompanyController {
    private Stage stage;

    @FXML
    private Button regButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField comapnyName;

    @FXML
    private TextField nip;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private TextField adress;

    @FXML
    private TextField city;

    @FXML
    private TextField zipcode;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/clientPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void regClick(ActionEvent event) {

    }

}
