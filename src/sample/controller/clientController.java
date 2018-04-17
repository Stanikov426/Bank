package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class clientController {

    private Stage stage;

    @FXML
    private Button backButton;

    @FXML
    void addCompanyClick(ActionEvent event) throws IOException {
        openPane("/sample/view/regCompanyPane.fxml");
    }

    @FXML
    void addPersonClick(ActionEvent event) throws IOException {
        openPane("/sample/view/regPane.fxml");
    }

    @FXML
    void backClick(ActionEvent event) throws IOException {
        openPane("/sample/view/mainMenu.fxml");
    }

    @FXML
    void deleteClick(ActionEvent event) {

    }

    @FXML
    void showAllClick(ActionEvent event) throws IOException {
        openPane("/sample/view/showAllPane.fxml");
    }

    @FXML
    void showCllientClick(ActionEvent event) {

    }

    private void openPane(String paneAdress) throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource(paneAdress));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
