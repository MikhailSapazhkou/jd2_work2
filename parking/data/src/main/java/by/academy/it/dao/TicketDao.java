package by.academy.it.dao;

import by.academy.it.pojo.Ticket;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface TicketDao {
    List<Ticket> readAllTickets() throws SQLException;

    Ticket getTicketByNumber(String licensePlateNumber) throws SQLException;

    void saveNewTicket(Ticket ticket) throws SQLException;

    void deleteAll() throws SQLException;

    void removeByNumber(String number) throws SQLException;

    List<Ticket> findByPersonIds(Set<Long> ids);
}
