package easedesk.test;

import easedesk.infra.DAO;
import easedesk.model.Ticket;
import easedesk.model.User;

public class TicketCreator {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>(User.class);

        User user = userDAO.obtainById(1L);
        userDAO.close();

        DAO<Ticket> ticketDAO = new DAO<>(Ticket.class);
        Ticket ticket = new Ticket("Printer exploded", user);
        ticketDAO.openTransaction();
        ticketDAO.include(ticket);
        ticketDAO.closeTransaction();

    }

}
