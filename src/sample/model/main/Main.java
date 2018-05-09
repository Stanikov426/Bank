package sample.model.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.bankClass.*;

import java.util.*;

import static sample.model.database.JacksonCoverterToJSON.saveJSON;
import static sample.model.database.SaveReadClass.*;

public class Main extends Application {
    private static List<KlientPrywatny> privClients = new LinkedList<>();
    private static List<KlientFirmowy> companyClients = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/mainMenu.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Bank System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        readSetupTxt();
        Set<String> listOfClientsId = getSetupList();
        for(String pom:listOfClientsId){
            addPrivClient(readPrivClients(pom));
        }
        for(String pom:listOfClientsId){
            addCompanyClient(readCompanyClients(pom));
        }

        /*
        Date d = new Date();
        KlientPrywatny test = new KlientPrywatny(1,"Michal","Stanikov",59);
        Kontakt k = new Kontakt(51515, "SADA@wp.pl");
        Adres a = new Adres("asda", "asd,sad", "trtttt");
        Konto ko = new Konto(0,"123",200);
        Operacja o = new Operacja(ko, ko,d, "Tstujes");
        test.dodajAdres(a);
        test.dodajKontakt(k);
        test.dodajKonto(ko);
        test.dodajOperacje(o);
        saveJSON(test);
        */

        launch(args);
        saveClients();
    }

    public static int randomId(){
        Random r = new Random();
        int x = r.nextInt(1000);
        System.out.println(x);
        for (KlientPrywatny pom: privClients) {
            if (pom.getId() == x) {
                return 0;
            }
        }
        for (KlientFirmowy pom: companyClients) {
            if (pom.getId() == x) {
                return 0;
            }
        }
        return x;
    }

    public static void addPrivClient(KlientPrywatny client){
        if(client!=null){
            privClients.add(client);
        }
    }

    public static void addCompanyClient(KlientFirmowy client){
        if(client!=null){
            companyClients.add(client);
        }
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
    public static Konto loginAcc(int accNumber, String password){
        for (Klient pom: privClients) {
            if(pom.findAcc(accNumber, password)!=null){
                return pom.findAcc(accNumber, password);
            }
        }
        for (Klient pom: companyClients) {
            if(pom.findAcc(accNumber, password)!=null){
                return pom.findAcc(accNumber, password);
            }
        }
        return null;
    }
    public static Klient loginClient(int accNumber, String password){
        for (Klient pom: privClients) {
            if(pom.findAcc(accNumber, password)!=null){
                return pom;
            }
        }
        for (Klient pom: companyClients) {
            if(pom.findAcc(accNumber, password)!=null){
                return pom;
            }
        }
        return null;
    }
    public static Konto getAccByNumber(int accNumber){
        for (Klient pom: privClients) {
            if(pom.findAcc(accNumber)!=null){
                return pom.findAcc(accNumber);
            }
        }
        for (Klient pom: companyClients) {
            if(pom.findAcc(accNumber)!=null){
                return pom.findAcc(accNumber);
            }
        }
        return null;
    }
    public static Klient getClientByAccNumber(int accNumber){
        for (Klient pom: privClients) {
            if(pom.findAcc(accNumber)!=null){
                return pom;
            }
        }
        for (Klient pom: companyClients) {
            if(pom.findAcc(accNumber)!=null){
                return pom;
            }
        }
        return null;
    }
    public static void deleteClientById(int idNumber){
        for (Klient pom: privClients) {
            if(pom.getId()==idNumber){
                privClients.remove(pom);
                deleteFile(pom.getStringId());
                return;
            }
        }
        for (Klient pom: companyClients) {
            if(pom.getId()==idNumber){
                companyClients.remove(pom);
                deleteFile(pom.getStringId());
                return;
            }
        }
    }

    private static void saveClients(){
        System.out.println("Saving Clients");
        for (Klient pom: privClients) {
            saveClient(pom);
            //Save to JSON
            //saveJSON(pom);
        }
        System.out.println("Saving Companies");
        for (Klient pom: companyClients) {
            saveClient(pom);
            //Save to JSON
            //saveJSON(pom);
        }
    }

}
