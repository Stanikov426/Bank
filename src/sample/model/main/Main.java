package sample.model.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.bank.Bank;
import sample.model.bankClass.Adres;
import sample.model.bankClass.KlientFirmowy;
import sample.model.bankClass.KlientPrywatny;
import sample.model.bankClass.Kontakt;

import java.util.List;
import java.util.LinkedList;

public class Main extends Application {
    public static int idCounter = 0;
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
        KlientPrywatny test = new KlientPrywatny(0,"Michal","Staniszewski",20);
        Kontakt testkon = new Kontakt(515192129,"M@wp.pl");
        Adres adrespom = new Adres("Rutki","Lomzynska 23", "18-312");
        test.dodajAdres(adrespom);
        test.dodajKontakt(testkon);
        idCounter++;
        addPrivClient(test);
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

    public static KlientPrywatny getPrivClientById(int pomId){
        for (KlientPrywatny pom: privClients) {
            if (pom.getId() == pomId) {
                return pom;
            }
        }
        return null;
    }

    public static KlientFirmowy getCompanyById(int pomId){
        for (KlientFirmowy pom: companyClients) {
            if (pom.getId() == pomId) {
                return pom;
            }
        }
        return null;
    }

}
