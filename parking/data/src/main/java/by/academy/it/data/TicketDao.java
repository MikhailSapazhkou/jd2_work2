package by.academy.it.data;

import by.academy.it.pojo.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {

    private DataSource dataSource;

    public TicketDao() throws ClassNotFoundException {
        this(false);
    }

    public TicketDao (boolean useTestDataSource) throws ClassNotFoundException {
        dataSource = new DataSource(useTestDataSource);

    }

    public List<Ticket> readAllTickets() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tickets");
        List<Ticket> ticketList = new ArrayList<>();
        while(rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setLicensePlateNumber(rs.getString("car_number"));
            ticket.setDate(rs.getTimestamp("ticket_date"));
            ticketList.add(ticket);
        }
        st.close();
        con.close();
        return ticketList;
    }

    public Ticket getTicketByNumber(String licensePlateNumber) throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM tickets WHERE car_number=?");
        st.setString(1, licensePlateNumber);
        ResultSet rs = st.executeQuery();
        Ticket ticket = null;
        if (rs.next()) {
            ticket = new Ticket();
            ticket.setLicensePlateNumber(rs.getString("car_number"));
            ticket.setDate(rs.getTimestamp("ticket_date"));
        }
        con.close();
        st.close();
        return ticket;
    }

    public void saveNewTicket(Ticket ticket) throws SQLException {
        Connection con = dataSource.getConnection();
        String sql = "INSERT INTO tickets VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setTimestamp(1, new Timestamp(ticket.getDate().getTime()));
        preparedStatement.setString(2, ticket.getLicensePlateNumber());
        preparedStatement.setLong(3, ticket.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        con.close();
    }

    public void deleteAll() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("TRUNCATE TABLE tickets").execute();
        connection.close();
    }

    public void removeByNumber(String number) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement(
                "DELETE FROM tickets where car_number='" + number + "' "
        ).execute();
        connection.close();
    }
}
