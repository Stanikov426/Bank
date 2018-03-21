package sample.model.database;

import java.sql.*;
import java.util.ArrayList;

import sample.model.bank.Account;
import sample.model.bank.Person;

public class Connector {

    private Connection conn;

    public Connector() {

        try {
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            conn = DriverManager.getConnection(url, "root", "admin");
        } catch (Exception msg) {
            System.out.println(msg.toString());
            System.out.println("Error!");
        }
    }

    public void addToDatabase(Account account) {
        PreparedStatement state;
        try {
            state = conn.prepareStatement("INSERT INTO account(id,password,cash,name,surname,age) VALUES (?,?,?,?,?,?)");
            state.setInt(1,account.getId());
            state.setString(2, account.getPassword());
            state.setInt(3, account.getCash());
            state.setString(4, account.getPerson().getName());
            state.setString(5, account.getPerson().getSurname());
            state.setInt(6, account.getPerson().getAge());
            state.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Blad");
        }
    }

    public void delete(int id, String passwd) {
        PreparedStatement state;
        try {
            state = conn.prepareStatement("DELETE FROM account WHERE id = ? AND password=?");
            state.setInt(1, id);
            state.setString(2, passwd);
            state.executeUpdate();
            System.out.println("Usunalem");
        } catch (SQLException e) {
            System.out.println("Blad");
        }
    }

    public void edit(Account g) {
        PreparedStatement state;
        try {
            state = conn.prepareStatement("UPDATE account set cash=? WHERE id =?");
            state.setInt(1, g.getCash());
            state.setInt(2, g.getId());
            state.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Blad");
        }

    }

    /*	public void showAllFromDatabase() {
            PreparedStatement state;
            ResultSet res;
            try {
                state = conn.prepareStatement("SELECT * FROM users WHERE id=1 ");
                res = state.executeQuery();
                while (res.next()) {
                    System.out.println("User: " + res.getInt("id") + " " + res.getString("username") + " "
                            + res.getString("password"));
                }
            } catch (SQLException e) {
                System.out.println("Blad");
            }
        }
    */
    public ArrayList importFromDatabase() {
        ArrayList<Account> list = new ArrayList<>();
        PreparedStatement state;
        ResultSet res;
        try {
            state = conn.prepareStatement("SELECT* FROM account");
            res = state.executeQuery();
            while (res.next()) {
                Person person = new Person(res.getString("name"), res.getString("surname"), res.getInt("age"));
                Account account = new Account(res.getInt("id"), res.getString("password"), person, res.getInt("cash"));
                list.add(account);
            }
        } catch (SQLException e) {
            System.out.println("Import fail");
        }

        return list;
    }

    public void exportToDatabase(ArrayList<Account> list)
    {
        PreparedStatement state;
        for(int i =0;i<list.size();i++) {
            try {
                state = conn.prepareStatement("INSERT INTO account(id,password,cash,name,surname,age) VALUES (?,?,?,?,?,?)");
                state.setInt(1,list.get(i).getId());
                state.setString(2, list.get(i).getPassword());
                state.setInt(3, list.get(i).getCash());
                state.setString(4, list.get(i).getPerson().getName());
                state.setString(5, list.get(i).getPerson().getSurname());
                state.setInt(6, list.get(i).getPerson().getAge());
                state.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Export fail");
            }
        }
    }
}
