package sample.model.bankClass;

public class KontoWalutowe extends Konto {
    private String waluta;

    public KontoWalutowe(int numerKonta, String haslo, double srodki, String waluta){
        super(numerKonta, haslo, srodki);
        this.waluta = waluta;
    }

    public void pokazSrodki(){
        System.out.println("Srodki: " + getSrodki() + waluta);
    }
}
