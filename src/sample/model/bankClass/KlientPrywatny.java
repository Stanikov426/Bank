package sample.model.bankClass;

public class KlientPrywatny extends Klient {
    private String imie;
    private String nazwisko;
    private int age;

    public KlientPrywatny(int id, String imie, String nazwisko, int age){
        super(id);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.age = age;
    }

    public String getStringId() {
        return String.valueOf(super.getId());
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String info() {
        return "" + getId() + " " + imie + " " + nazwisko + " " + age + " " + adress.czytaj() + " " + contact.czytaj();
    }
}
