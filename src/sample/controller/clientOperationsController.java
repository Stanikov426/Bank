package sample.controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.model.bankClass.Konto;
import sample.model.bankClass.Operacja;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static sample.controller.showClientController.pomClient;
import static sample.controller.showClientController.pomCompany;

public class clientOperationsController implements Initializable {
    private Stage stage;

    @FXML
    private TableView<Operacja> operationsTable;

    @FXML
    private TableColumn<Operacja, String> dateColumn;

    @FXML
    private TableColumn<Operacja, String> accNumberColumn;

    @FXML
    private TableColumn<Operacja, String> toColumn;

    @FXML
    private TableColumn<Operacja, String> descriptionColumn;

    @FXML
    private Button backButton;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/showClientPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dateColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getStringData()));
        accNumberColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getAccNumber()));
        toColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getToNumber()));
        descriptionColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDescription()));

        operationsTable.setItems(getOperationsList());
    }

    private ObservableList<Operacja> getOperationsList() {
        ObservableList<Operacja> operationsList = FXCollections.observableArrayList();
        List<Operacja> operations = null;
        if(pomClient!=null){
            operations = pomClient.getOperacje();
        }
        else{
            operations = pomCompany.getOperacje();
        }
        for (Operacja pom : operations) {
            operationsList.add(pom);
        }

        return operationsList;
    }
}

