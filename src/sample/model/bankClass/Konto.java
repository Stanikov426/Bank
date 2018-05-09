package sample.model.bankClass;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Konto implements Serializable {
    private double srodki;
    private String currency = "PLN";
    private int numerKonta;
    private String type;
    private String haslo;
    private List<Operacja> operacjeKonta;

    public Konto(int numerKonta, String haslo, double srodki){
        this.numerKonta = numerKonta;
        this.haslo = haslo;
        this.srodki = srodki;
        setType("Standard");
        operacjeKonta = new LinkedList<>();
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
    public void dodajOperacje(Operacja operacja){
        operacjeKonta.add(operacja);
    }

    public List<Operacja> getOperacje() {
        return operacjeKonta;
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

    public String getCurrency() {
        return currency;
    }

    public Boolean checkNumberAndPassword(int accNumber, String password){
        if(numerKonta==accNumber && haslo.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean checkNumber(int accNumber){
        if(numerKonta==accNumber){
            return true;
        }
        else{
            return false;
        }
    }
    public void depositCash(double howMuch){
        srodki= srodki+howMuch;
    }
    public Boolean withdrawCash(double howMuch){
        if(howMuch>srodki){
            return false;
        }
        else {
            srodki= srodki - howMuch;
            return true;
        }
    }

}
