package by.academy.it.web;

import by.academy.it.controller.PersonController;
import by.academy.it.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/person", name = "personServlet")
public class PersonServlet extends HttpServlet {

    private PersonController personController;

    @Override
    public void init() throws ServletException {
        personController = new PersonController();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if ("new".equals(command)) {
            Person person = new Person();
            person.setName(req.getParameter("name"));
            person.setSecondName(req.getParameter("second_name"));
            List<String> errors =
                    personController.saveNewPerson(person);
            if (errors.isEmpty()) {
                req.setAttribute("persons", personController.getAllPersons());
                req.getRequestDispatcher("/persons.jsp").forward(req, resp);
            } else {
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("/add-person.jsp").forward(req, resp);
            }
        }
    }
}
