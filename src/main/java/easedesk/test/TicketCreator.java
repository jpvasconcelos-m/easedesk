package easedesk.test;

import easedesk.infra.DAO;
import easedesk.model.Ticket;
import easedesk.model.User;

public class TicketCreator {


    public static void main(String[] args) {
        User user1 = new User("Renato Trajano Melo","renatotrajanom@gmail.com",false);
        User user2 = new User("Luis Fernandes Alcântara","lfa@gmail.com",false);
        User user3 = new User("Joelma Tamires Dionísio","joelmadionisio97@gmail.com",false);
        User user4 = new User("João Pedro Vasconcelos","joaopedrosao@gmail.com",true);

        Ticket ticket1 = new Ticket("Printer Exploded",user1,user4);
        Ticket ticket2 = new Ticket("System is down!",user2,user4);
        Ticket ticket3 = new Ticket("Computer is in bluescreen loop!",user1,user4);


        DAO<User> dao1 = new DAO<>(User.class);
        dao1.openTransaction();
        dao1.include(user1);
        dao1.include(user2);
        dao1.include(user3);
        dao1.include(user4);
        dao1.closeTransaction();

        DAO<Ticket> dao2 = new DAO<>(Ticket.class);
        dao2.openTransaction();
        dao2.include(ticket1);
        dao2.include(ticket2);
        dao2.include(ticket3);
        dao2.closeTransaction();


        System.out.println("User1 ID:" + user1.getId());
        System.out.println("User2 ID:" + user2.getId());


        System.out.println("Ticket1 ID: "+ ticket1.getId() );
        System.out.println("Ticket2 ID: "+ ticket2.getId() );
    }












}
