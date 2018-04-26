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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.model.bankClass.KlientPrywatny;
import sample.model.bankClass.Konto;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static sample.controller.showClientController.pomClient;
import static sample.controller.showClientController.pomCompany;
import static sample.model.main.Main.getPrivClients;

public class showAccController implements Initializable {
    private Stage stage;

    @FXML
    private Label headLabel;

    @FXML
    private TableView<Konto> accountTable;

    @FXML
    private TableColumn<Konto, String> typeColumn;

    @FXML
    private TableColumn<Konto, String> numberColumn;

    @FXML
    private TableColumn<Konto, String> cashColumn;

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
        if(pomClient!=null){
            headLabel.setText(pomClient.getImie() + " Accounts");
        }
        else{
            headLabel.setText(pomCompany.getNazwaFirmy()+" Accounts");
        }

        typeColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getType()));
        numberColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getStringNumerKonta()));
        cashColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().pokazSrodki()));

        accountTable.setItems(getAccList());
    }

    private ObservableList<Konto> getAccList() {
        ObservableList<Konto> clientsList = FXCollections.observableArrayList();
        List<Konto> clients = null;
        if(pomClient!=null){
            clients = pomClient.getKonta();
        }
        else{
            clients = pomCompany.getKonta();
        }
        for (Konto num : clients) {
            clientsList.add(num);
        }

        return clientsList;
    }
}
