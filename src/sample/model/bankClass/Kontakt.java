package sample.model.bankClass;

public class Kontakt {
    private int nrTel;
    private String email;

    public Kontakt(int nrTel, String email){
        this.nrTel = nrTel;
        this.email = email;
    }

    public int getNrTel() {
        return nrTel;
    }

    public void setNrTel(int nrTel) {
        this.nrTel = nrTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String czytaj(){
        return "Telefon: " + nrTel + " Mail: "+ email;
    }

}
