package sample.model.main;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {
    Scanner scanner = new Scanner(System.in);
    public String enterCheckName() {
        Pattern pattern = Pattern.compile("([a-zA-Z])*");
        Matcher matcher;
        boolean truth = true;
        String name = null;
        while (truth) {
            System.out.println("Please write your name");
            name = scanner.next();
            matcher = pattern.matcher(name);
            if (matcher.matches())
                truth = false;
        }
        return name;
    }

    public String enterCheckSurname() {
        Pattern pattern = Pattern.compile("([a-zA-Z])*");
        Matcher matcher;
        boolean truth = true;
        String surname = null;
        while (truth) {
            System.out.println("Please write your surname");
            surname = scanner.next();
            matcher = pattern.matcher(surname);
            if (matcher.matches())
                truth = false;
        }
        return surname;
    }

    public String enterPasswd() {
        String password;
        System.out.println("Please enter your password");
        password = scanner.next();
        return password;
    }

    public int eneterCheckId() {
        int id=0;
        System.out.println("Please enter your id");
        id=scanner.nextInt();
        return id;
    }

    public int eneterCheckCash() {
        int cash=0;
        System.out.println("Please amount of cash");
        cash=scanner.nextInt();
        return cash;
    }


    public int eneterCheckAge() {
        int age = 0;
        boolean truth = true;
        try {
            while (truth) {
                System.out.println("Please write your age");
                age = scanner.nextInt();
                if (age > 16)
                    truth = false;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return age;

    }
}
