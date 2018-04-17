package sample.model.bankClass;

import java.util.HashSet;
import java.util.Set;

public class Konto {
    private double srodki;
    private int numerKonta;
    private String haslo;
    private Set<Operacje> operacje;

    public Konto(int numerKonta, String haslo, double srodki){
        this.numerKonta = numerKonta;
        this.haslo = haslo;
        this.srodki = srodki;
        operacje = new HashSet<Operacje>();
    }

    public double getSrodki() {
        return srodki;
    }

    public void setSrodki(double srodki) {
        this.srodki = srodki;
    }

    public void pokazSrodki(){
        System.out.println("Srodki: " + getSrodki() + "PLN");
    }
    public void dodajOperacje(Operacje operacja){
        operacje.add(operacja);
    }
    public void pokazOperacje(){
        for (Operacje pomOpercaje: operacje) {
            pomOpercaje.pokaz();
        }
    }
}
