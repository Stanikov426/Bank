package sample.model.bankClass;

public class Kontakt {
    private int nrTel;
    private String email;

    public Kontakt(int nrTel, String email){
        this.nrTel = nrTel;
        this.email = email;
    }

    public String czytaj(){
        return "Telefon: " + nrTel + " Mail: "+ email;
    }
}
