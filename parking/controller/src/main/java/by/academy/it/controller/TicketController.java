package by.academy.it.controller;

import by.academy.it.data.Ticket;
import by.academy.it.data.TicketDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketController {

    TicketDao ticketDao;

    public TicketController() throws ClassNotFoundException {
        ticketDao = new TicketDao();
    }

    public List<String> handleTicketRequest(String number, Date currentDate) throws SQLException {
        List<String> messages = new ArrayList<>();
        if (ticketDao.getTicketByNumber(number) != null) {
            Date startDate = ticketDao.getTicketByNumber(number).getDate();
            ticketDao.removeByNumber(number);
            long seconds = (currentDate.getTime() - startDate.getTime()) / 1000;
            messages.add("You stayed in our parking:");
            messages.add(seconds + " seconds");
        } else {
            Ticket ticket = new Ticket();
            ticket.setLicensePlateNumber(number);
            ticket.setDate(currentDate);
            ticketDao.saveNewTicket(ticket);
            messages.add("Welcome to our Parking!");
            messages.add(currentDate.toString());
        }
        return messages;
    }

}
