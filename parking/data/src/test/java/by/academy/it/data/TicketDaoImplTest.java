package by.academy.it.data;

import by.academy.it.pojo.Ticket;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TicketDaoImplTest {

    TicketDaoImpl ticketDaoImpl;

    @org.junit.Before
    public void setUp() throws Exception {
        ticketDaoImpl = new TicketDaoImpl(true);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInstance() {
        assertNotNull(ticketDaoImpl);
    }

    @Test
    public void testSaveNewTicket() throws SQLException {
        //Given
        Ticket newTicket = new Ticket();
        newTicket.setDate(new Date());
        newTicket.setLicensePlateNumber("1234test");
        //When
        ticketDaoImpl.saveNewTicket(newTicket);
        //Then
        Ticket ticket = ticketDaoImpl.readAllTickets().get(0);
        assertNotNull(ticket);
        assertEquals("1234test", ticket.getLicensePlateNumber());
        ticketDaoImpl.deleteAll();
    }
}