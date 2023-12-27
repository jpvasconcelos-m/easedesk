package easedesk.test;

import easedesk.infra.DAO;
import easedesk.model.User;


public class UserCreator {

    public static void main(String[] args) {
        User user1 = new User("Renato Trajano Melo","renatotrajanom@gmail.com",false);
        User user2 = new User("Luis Fernandes Alcântara","lfa@gmail.com",false);
        User user3 = new User("Joelma Tamires Dionísio","joelmadionisio97@gmail.com",false);
        User user4 = new User("Joelma Tamires Dionísio","joaopedrosao@gmail.com",false);

        DAO<User> dao = new DAO<>(User.class);
        dao.openTransaction();
        dao.include(user1);
        dao.include(user2);
        dao.include(user3);
        dao.closeTransaction();

        System.out.println("User1 ID:" + user1.getId());
        System.out.println("User2 ID:" + user2.getId());
    }



}
