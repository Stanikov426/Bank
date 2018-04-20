package sample.model.bankClass;

public class KlientFirmowy extends Klient {
    private String nazwaFirmy;
    private int nip;

    public KlientFirmowy(int id, String nazwaFirmy, int nip){
        super(id);
        this.nazwaFirmy = nazwaFirmy;
        this.nip = nip;
    }

    public String info() {
        return "Id:" + getId() + " Name: " + nazwaFirmy + " Nip: " + nip;
    }
    public String getContactInfo(){
        return contact.czytaj();
    }
    public String getAdressInfo(){
        return adress.czytaj();
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
    public String getStringNip(){
        return String.valueOf(nip);
    }
}
