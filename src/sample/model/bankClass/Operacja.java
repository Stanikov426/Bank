package sample.model.bankClass;

import java.io.Serializable;
import java.util.Date;

public class Operacja implements Serializable {
    private Date data;
    private Konto kontoOdbiorcy;
    private Konto kontoNadawcy;
    private String description;

    public Operacja(Konto accFrom, Konto accTo, Date date, String type){
        this.data = date;
        this.description = type;
        this.kontoNadawcy = accFrom;
        this.kontoOdbiorcy = accTo;
    }

    public String getStringData() {
        return data.toString();
    }

    public String getAccNumber(){
        return kontoNadawcy.getStringNumerKonta();
    }

    public String getToNumber(){
        return kontoOdbiorcy.getStringNumerKonta();
    }

    public String getDescription() {
        return description;
    }
}
