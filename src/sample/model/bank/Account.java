package sample.model.bank;


public class Account {
    private int id;
    private String password;
    private int cash;
    private Person person;

    public Account(int id, String password, Person person,int cash) {
        this.cash = cash;
        this.id = id;
        this.password = password;
        this.person = person;
    }
    public Account(int id, String password, Person person) {
        this.cash = 0;
        this.id = id;
        this.password = password;
        this.person = person;
    }

    public void addCash(int cash) {
        this.cash += cash;
    }

    public void removeCash(int cash) {
        if (this.cash >= cash)
            this.cash -= cash;
        else
            System.out.println("You dont have enought money on your account");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Account id=" + id + ", cash=" + cash + ",person details: " + person;
    }

    public boolean equals(Account obj) {

        if ((this.getPassword() == obj.getPassword()) && this.getId() == obj.getId())
            return true;
        return false;
    }

}
