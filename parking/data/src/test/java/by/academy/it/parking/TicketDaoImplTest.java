package by.academy.it.parking;

import by.academy.it.config.TestDaoConfiguration;
import by.academy.it.dao.TicketDao;
import by.academy.it.parking.pojo.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = TestDaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TicketDaoImplTest {

    @Autowired
    TicketDao ticketDao;

    @Test
    public void testInstance() {
        assertNotNull(ticketDao);
    }

    @Test
    public void testSaveNewTicket() throws SQLException {
        //Given
        Ticket newTicket = new Ticket();
        newTicket.setDate(new Date());
        newTicket.setLicensePlateNumber("1234test");
        //When
        ticketDao.saveNewTicket(newTicket);
        //Then
        Ticket ticket = ticketDao.readAllTickets().get(0);
        assertNotNull(ticket);
        assertEquals("1234test", ticket.getLicensePlateNumber());
        ticketDao.deleteAll();
    }
}