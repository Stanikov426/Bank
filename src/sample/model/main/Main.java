package sample.model.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.bank.Bank;
import sample.model.bankClass.KlientFirmowy;
import sample.model.bankClass.KlientPrywatny;

import java.util.List;
import java.util.LinkedList;

public class Main extends Application {
    public static Bank test = new Bank();
    private static List<KlientPrywatny> privClients = new LinkedList<>();
    private static List<KlientFirmowy> companyClients = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //test.importFromDatabase();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/mainMenu.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Bank System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        for (KlientPrywatny pom: privClients) {
            System.out.println(pom.info());
        }
    }

    public static void addPrivClient(KlientPrywatny client){
        privClients.add(client);
    }

    public static void addCompanyClient(KlientFirmowy client){
        companyClients.add(client);
    }

    public static List<KlientPrywatny> getPrivClients() {
        return privClients;
    }

    public static List<KlientFirmowy> getCompanyClients() {
        return companyClients;
    }

}
