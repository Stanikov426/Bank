package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static sample.model.main.Main.test;

public class clientController {

    private Stage stage;
    public static int pomId;

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
    void showCllientClick(ActionEvent event) throws IOException {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Show client");
        dialog.setHeaderText("Find client by id");
        dialog.setContentText("Please id:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            pomId = Integer.valueOf(result.get().toString());
            openPane("/sample/view/showClientPane.fxml");
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
