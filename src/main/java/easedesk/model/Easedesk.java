package easedesk.model;


//Main class!
//TODO Implement Spring boot framework!


import easedesk.infra.DAO;

public class Easedesk {
    public static void main(String[] args) {
        //TODO create method for each function using other class from model.
        showMenu();


    }

    static void showMenu(){
        System.out.println("Menu:");
        System.out.println(" 1 - Login");
        System.out.println(" 2 - Forgot my credentials");
        System.out.println(" 3 - Register");
    }
    static void register(String name, String email, boolean isAdmin){
        //TODO create later overwrite with an method with friendly user Interface, not CLI.




    }









}