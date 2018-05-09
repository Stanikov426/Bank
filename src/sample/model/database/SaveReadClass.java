package sample.model.database;

import sample.model.bankClass.Klient;
import sample.model.bankClass.KlientFirmowy;
import sample.model.bankClass.KlientPrywatny;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaveReadClass {
    private static Set<String> setupList = new HashSet<>();

    public static Set<String> getSetupList() {
        return setupList;
    }

    public static void saveClient(Klient client){
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(client.getId());
        fileNameBuilder.append(".obj");
        String fileName = fileNameBuilder.toString();

        try(
                FileOutputStream fs = new FileOutputStream(fileName);
                ObjectOutputStream os = new ObjectOutputStream(fs);
        ) {
            os.writeObject(client);
            saveSetupTxt(fileName);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Zapisano obiekt do pliku");
        setupList.add(fileName);
        saveSetupTxt(fileName);
    }

    public static KlientPrywatny readPrivClients(String name){
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(name);
        String fileName = fileNameBuilder.toString();

        KlientPrywatny p1 = null;

        try(
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            p1 = (KlientPrywatny) ois.readObject();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassCastException e) {
            //e.printStackTrace();
        }

        if(p1 != null) {
            System.out.println("Wczytano dane");
            return p1;
        }else {
            return null;
        }
    }
    public static KlientFirmowy readCompanyClients(String name){
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(name);
        String fileName = fileNameBuilder.toString();

        KlientFirmowy p1 = null;

        try(
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            p1 = (KlientFirmowy) ois.readObject();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassCastException e) {
            //e.printStackTrace();
        }

        if(p1 != null) {
            System.out.println("Wczytano dane");
            return p1;
        }else {
            return null;
        }
    }
    public static void readSetupTxt() {
        String fileName = "setup.txt";
        File file = new File(fileName);

        boolean fileExists = file.exists();
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.out.println("File not created");
                return;
            }
        }

        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                System.out.println(nextLine);
                setupList.add(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void saveSetupTxt(String nowy){
        String fileName = "setup.txt";
        try(
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter writer = new BufferedWriter(fileWriter);
        ) {
            for(String a:setupList) {
                System.out.println(a);
                writer.write(a);
                writer.newLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String pathFile){
        String fileName = pathFile + ".obj";
        Path fileToDeletePath = Paths.get(fileName);
        try {
            Files.delete(fileToDeletePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setupList.remove(fileName);
    }
}
