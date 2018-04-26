package sample.model.bankClass;

import java.util.Date;

public class Operacja {
    private Date data;
    private Klient odbiorca;
    private Klient nadawca;
    private Konto kontoOdbiorcy;
    private Konto kontoNadawcy;
    private String description;

    public Operacja(){}

    public Operacja(Klient from, Konto owner, Date date, String type){
        this.data = date;
        this.nadawca = from;
        this.description = type;
        this.kontoNadawcy = owner;
    }

    public Operacja(Klient from, Klient to, Konto accFrom, Konto accTo, Date date, String type){
        this.data = date;
        this.nadawca = from;
        this.odbiorca = to;
        this.description = type;
        this.kontoNadawcy = accFrom;
        this.kontoOdbiorcy = accTo;
    }

    public void wyplac(Klient klient, Konto konto, double ilosc){
        konto.setSrodki(konto.getSrodki()-ilosc);
        data = new Date();
        nadawca = klient;
        description = "Wyplata";
    }
    public void wplac(Klient klient, Konto konto, double ilosc){
        konto.setSrodki(konto.getSrodki()+ilosc);
        data = new Date();
        nadawca = klient;
        description = "Wplata";
    }
    public void przelew() {

    }
    public void pokaz(){
        System.out.printf("%1$s %2$td %2$tB %2$tY\n", "Data:", data);
        System.out.printf("%2$tT\n", "Godzina:", data);
        System.out.println(description + " ");
    }
}
