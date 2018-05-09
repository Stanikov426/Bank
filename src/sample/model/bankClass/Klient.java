package sample.model.bankClass;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class Klient implements Serializable {
    private int id;
    protected Kontakt contact;
    protected Adres adress;
    private List<Konto> konta;
    private List<Operacja> operacjeKlienta;

    public Klient(int id){
        this.id = id;
        konta = new LinkedList<>();
        operacjeKlienta = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getStringId() {
        return String.valueOf(id);
    }

    public void dodajKontakt(Kontakt kontakt){
        contact = kontakt;
    }

    public Kontakt getContact() {
        return contact;
    }

    public void dodajAdres(Adres pomAdres){
        adress = pomAdres;
    }

    public Adres getAdress() {
        return adress;
    }

    public String getCity(){
        return adress.getMiasto();
    }

    public void dodajKonto(Konto konto){
        konta.add(konto);
    }

    public void deleteAccByNumber(String accNumber){
        for (Konto pomKonto: konta) {
            if(pomKonto.getStringNumerKonta().equals(accNumber)){
                konta.remove(pomKonto);
            }
        }
    }
    public void dodajOperacje(Operacja operacja){
        operacjeKlienta.add(operacja);
    }

    public void addOperationToAcc(Konto acc, Operacja operacja){
        for(Konto pom:konta){
            if(pom.equals(acc)){
                pom.dodajOperacje(operacja);
            }
        }
    }

    public List<Operacja> getOperacje() {
        return operacjeKlienta;
    }

    public String info(){
        return "" + id;
    }

    public List<Konto> getKonta() {
        return konta;
    }

    public Konto findAcc(int accNumber, String password){
        for(Konto pom:konta){
            if(pom.checkNumberAndPassword(accNumber, password)){
                return pom;
            }
        }
        return null;
    }
    public Konto findAcc(int accNumber){
        for(Konto pom:konta){
            if(pom.checkNumber(accNumber)){
                return pom;
            }
        }
        return null;
    }
}
