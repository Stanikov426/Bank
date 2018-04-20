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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.model.bankClass.KlientFirmowy;
import sample.model.bankClass.KlientPrywatny;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static sample.model.main.Main.*;

public class showAllController implements Initializable{
    private Stage stage;

    @FXML
    private TableView<KlientPrywatny> clientsTable;

    @FXML
    private TableColumn<KlientPrywatny, String> idClientColumn;

    @FXML
    private TableColumn<KlientPrywatny, String> cityColumn;

    @FXML
    private TableColumn<KlientPrywatny, String> nameColumn;

    @FXML
    private TableColumn<KlientPrywatny, String> surnameColumn;

    @FXML
    private TableView<KlientFirmowy> companyTable;

    @FXML
    private TableColumn<KlientFirmowy, String> idCompanyColumn;

    @FXML
    private TableColumn<KlientFirmowy, String> companyNameColumn;

    @FXML
    private TableColumn<KlientFirmowy, String> nipColumn;

    @FXML
    private Button backButton;

    @FXML
    void backClick(ActionEvent event) throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/sample/view/clientPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Clients
        idClientColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getStringId()));
        cityColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getCity()));
        nameColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getImie()));
        surnameColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNazwisko()));

        clientsTable.setItems(getPrivateClientsList());

        //Company
        idCompanyColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getStringId()));
        companyNameColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNazwaFirmy()));
        nipColumn.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getStringNip()));

        companyTable.setItems(getCompanyClientsList());

    }

    private ObservableList<KlientPrywatny> getPrivateClientsList() {
        ObservableList<KlientPrywatny> clientsList = FXCollections.observableArrayList();
        List<KlientPrywatny> clients = getPrivClients();
        for (KlientPrywatny num : clients) {
            clientsList.add(num);
        }

        return clientsList;
    }

    private ObservableList<KlientFirmowy> getCompanyClientsList() {
        ObservableList<KlientFirmowy> clientsList = FXCollections.observableArrayList();
        List<KlientFirmowy> clients = getCompanyClients();
        for (KlientFirmowy num : clients) {
            clientsList.add(num);
        }

        return clientsList;
    }
}

