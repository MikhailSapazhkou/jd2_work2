package by.academy.it.data;

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

    public void saveNewTicket(Ticket ticket) throws SQLException {
        Connection con = dataSource.getConnection();
        String sql = "INSERT INTO tickets VALUES (?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setDate(1, new Date(ticket.getDate().getTime()));
        preparedStatement.setString(2, ticket.getLicensePlateNumber());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        con.close();
    }

    public void deleteAll() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("TRUNCATE TABLE tickets").execute();
        connection.close();
    }
}
