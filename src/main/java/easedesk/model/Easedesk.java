package easedesk.model;


//Main class!
//TODO Implement Spring boot framework!


import easedesk.infra.DAO;

import java.util.List;
import java.util.Scanner;

public class Easedesk {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //TODO create method for each function using other class from model.
        showMenu();
        addToDB(new User("João Pedro Vasconcelos Mendes","joaopedrosao@gmail.com",true));
        register();




    }

    static void showMenu(){
        System.out.println("Menu:");
        System.out.println(" 1 - Login");
        System.out.println(" 2 - Forgot my credentials");
        System.out.println(" 3 - Register");
    }

    static void register(){
        while(true) {
            try {
                System.out.println("Inform your name");
                String name = sc.nextLine();
                System.out.println("Inform your email :");
                String email = sc.nextLine();
                System.out.println("You're admin? (Y/N)");
                Object isAdmin = sc.nextLine();
                if (isAdmin.toString().equalsIgnoreCase("YES") || (isAdmin.toString().equalsIgnoreCase("Y"))) {
                    isAdmin = true;
                    System.out.println(isAdmin);
                } else if (isAdmin.toString().equalsIgnoreCase("NO") || (isAdmin.toString().equalsIgnoreCase("N"))) {
                    isAdmin = false;
                    System.out.println(isAdmin);
                } else
                    System.out.println(isAdmin);

                addToDB(new User(name, email, (boolean) isAdmin));
                break;
            }
            catch (ClassCastException exception){
                System.out.println("Invalid value! Try again!");

            }
        }


    }
    static void addToDB(User user){

        DAO<User> dao = new DAO<>(User.class);

        dao.openTransaction();
        dao.include(user);
        dao.closeTransaction();

       }
    static void search(){
        DAO<User> dao = new DAO<>(User.class);
        List<User> users = dao.query("obtainUsersEmailEqualsTo");
        for(User u : users){
            System.out.println(u.getName());
        }






    }









}
