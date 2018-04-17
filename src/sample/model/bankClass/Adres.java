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
}
