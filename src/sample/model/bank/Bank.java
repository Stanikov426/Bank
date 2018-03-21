package sample.model.bank;

import sample.model.database.Connector;
import sample.model.main.CheckData;

import java.util.ArrayList;

public class Bank {

    CheckData check= new CheckData();
    Connector x = new Connector();
    ArrayList<Account> accounts = new ArrayList<>();
    Account pom;

    public void importFromDatabase() {
        accounts=x.importFromDatabase();
    }

    public Account LogInCheck(int id,String password)
    {
        for(int i=0;i<accounts.size();i++)
        {
            if((accounts.get(i).getId()==id)&&(accounts.get(i).getPassword().equals(password)))
            {
                System.out.println("Welcome!");
                pom = accounts.get(i);
                return accounts.get(i);
            }
        }
        System.out.println("Access denied");
        return null;
    }

    public void deleteBankAccount(Account account) {
        x.delete(account.getId(), account.getPassword());
        accounts.remove(account);
    }

    public void showAccountList()
    {
        for(int i=0;i<accounts.size();i++) {
            System.out.println(accounts.get(i).getId()+" "+accounts.get(i).getPassword());
        }
    }
    public void addAccount(Account test){
        accounts.add(test);
        pom = test;
        x.addToDatabase(test);
    }
    public Account getAccount(){
        return pom;
    }

    public void edit(Account test){
        x.edit(test);
    }

}
