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
        return "" + getId() + " " + nazwaFirmy + " " + nip;
    }
}
