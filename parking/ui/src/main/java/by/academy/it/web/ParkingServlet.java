package by.academy.it.web;

import by.academy.it.data.Ticket;
import by.academy.it.data.TicketDao;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "parkingServlet", urlPatterns = "/parking")
public class ParkingServlet extends HttpServlet {

    //private Map<String, Date> map = new HashMap<>();
    private TicketDao ticketDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            ticketDao = new TicketDao();
        } catch (ClassNotFoundException e) {
            throw new ServletException(
                    "Cannot instantiate TicketDao",
                    e);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter writer = resp.getWriter();
            resp.setContentType("text/html");
            HttpSession session = req.getSession();

            String number = req.getParameter("number");
            addParkingCookies(resp, number);
            Date currentDate = new Date();
            if (ticketDao.getTicketByNumber(number) != null) {
                Date startDate = ticketDao.getTicketByNumber(number).getDate();
                ticketDao.removeByNumber(number);
                long seconds = (currentDate.getTime() - startDate.getTime())/1000;
                writer.println("You stayed in our parking:");
                writer.println(seconds + " seconds");
            } else {
                Ticket ticket = new Ticket();
                ticket.setLicensePlateNumber(number);
                ticket.setDate(currentDate);
                ticketDao.saveNewTicket(ticket);
                writer.println("Welcome to our Parking!");
                writer.println(currentDate);
            }
            writer.println("Car Number: " + number);
            session.setAttribute("number", number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void addParkingCookies(HttpServletResponse resp, String number) {
        Cookie cookie = new Cookie("PLATENUMBER", number);
        cookie.setMaxAge(300);
        resp.addCookie(cookie);
    }
}
