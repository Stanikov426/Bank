package sample.model.bankClass;

public class Adres {
    private String miasto;
    private String adress;
    private String kodPocztowy;

    public Adres(String miasto, String adress, String kodPocztowy){
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.adress = adress;
    }
    public String czytaj(){
        return "Adres: "+ adress + " " + miasto +" " + kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}
