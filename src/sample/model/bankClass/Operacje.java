package sample.model.bankClass;

import java.util.Date;

public class Operacje {
    private Date data;
    private Klient odbiorca;
    private Klient nadawca;
    private String rodzaj;

    public Operacje(){}

    public void wyplac(Klient klient, Konto konto, double ilosc){
        konto.setSrodki(konto.getSrodki()-ilosc);
        data = new Date();
        nadawca = klient;
        rodzaj = "Wyplata";
    }
    public void wplac(Klient klient, Konto konto, double ilosc){
        konto.setSrodki(konto.getSrodki()+ilosc);
        data = new Date();
        nadawca = klient;
        rodzaj = "Wplata";
    }
    public void przelew() {

    }
    public void pokaz(){
        System.out.printf("%1$s %2$td %2$tB %2$tY\n", "Data:", data);
        System.out.printf("%2$tT\n", "Godzina:", data);
        System.out.println(rodzaj + " ");
    }
}
