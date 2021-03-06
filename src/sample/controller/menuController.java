package sample.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class menuController {

    private Stage stage;

    @FXML
    private Button logButton;

    @FXML
    private Button clientButton;

    @FXML
    void exitClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void loginClick(ActionEvent event) throws IOException {
        openPane("/sample/view/logPane.fxml");
    }

    @FXML
    void clientClick(ActionEvent event) throws IOException {
        openPane("/sample/view/clientPane.fxml");
    }

    private void openPane(String paneAdress) throws IOException {
        stage = (Stage) logButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource(paneAdress));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
