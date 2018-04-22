package sample.model.bankClass;

import java.util.HashSet;
import java.util.Set;

public class Konto {
    private double srodki;
    private String currency = "PLN";
    private int numerKonta;
    private String type;
    private String haslo;
    private Set<Operacje> operacje;

    public Konto(int numerKonta, String haslo, double srodki){
        this.numerKonta = numerKonta;
        this.haslo = haslo;
        this.srodki = srodki;
        setType("Standard");
        operacje = new HashSet<Operacje>();
    }

    public double getSrodki() {
        return srodki;
    }

    public void setSrodki(double srodki) {
        this.srodki = srodki;
    }

    public String pokazSrodki(){
        return "" + srodki+currency;
    }
    public void dodajOperacje(Operacje operacja){
        operacje.add(operacja);
    }
    public void pokazOperacje(){
        for (Operacje pomOpercaje: operacje) {
            pomOpercaje.pokaz();
        }
    }

    public String getStringNumerKonta() {
        return "" + numerKonta;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
