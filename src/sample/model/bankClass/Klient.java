package sample.model.bankClass;

import java.util.HashSet;
import java.util.Set;

public abstract class Klient {
    private int id;
    protected Kontakt contact;
    protected Adres adress;
    private Set<Konto> konta;
    private Set<Operacje> operacje;

    public Klient(int id){
        this.id = id;
        konta = new HashSet<Konto>();
        operacje = new HashSet<Operacje>();
    }

    public int getId() {
        return id;
    }

    public void dodajKontakt(Kontakt kontakt){
        contact = kontakt;
    }

    public void dodajAdres(Adres pomAdres){
        adress = pomAdres;
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
    public void dodajOperacje(Operacje operacja){
        operacje.add(operacja);
    }
    public void pokazOperacje(){
        for (Operacje pomOpercaje: operacje) {
            pomOpercaje.pokaz();
        }
    }

    public String info(){
        return "" + id;
    }
}
