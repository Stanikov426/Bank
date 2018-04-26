package sample.model.bankClass;

import java.util.LinkedList;
import java.util.List;

public abstract class Klient {
    private int id;
    protected Kontakt contact;
    protected Adres adress;
    private List<Konto> konta;
    private List<Operacja> operacje;

    public Klient(int id){
        this.id = id;
        konta = new LinkedList<>();
        operacje = new LinkedList<>();
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

    public void pokazKonta(){
        for (Konto pomKonto: konta) {
            pomKonto.pokazSrodki();
        }
    }
    public void dodajOperacje(Operacja operacja){
        this.operacje.add(operacja);
    }
    public void pokazOperacje(){
        for (Operacja pomOpercaje: operacje) {
            pomOpercaje.pokaz();
        }
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
