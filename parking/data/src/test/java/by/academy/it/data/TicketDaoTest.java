package by.academy.it.data;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TicketDaoTest {

    TicketDao ticketDao;

    @org.junit.Before
    public void setUp() throws Exception {
        ticketDao = new TicketDao();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInstance() {
        assertNotNull(ticketDao);
    }

    @Test
    public void testGetConnection() throws SQLException {
        Connection con = ticketDao.getConnection();
        assertNotNull(con);
        con.close();
    }

    @Test
    public void testRealAllTickets() throws SQLException {
        List<Ticket> ticketList = ticketDao.readAllTickets();
        assertNotNull(ticketList);
        assertEquals(1, ticketList.size());
    }
}