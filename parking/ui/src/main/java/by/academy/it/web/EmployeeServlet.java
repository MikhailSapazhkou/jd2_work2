package by.academy.it.web;

import by.academy.it.company.Employee;
import by.academy.it.controller.EmployeeController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EmployeeServlet extends HttpServlet {

    EmployeeController employeeController = new EmployeeController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("add-new.employee".equals(req.getParameter("command")) {
            Employee employee = new Employee(
                    req.getParameter("firstName"),
                    req.getParameter("secondName"),
                    req.getParameter("phoneNumber")
            );
            boolean result = employeeController.save(employee);
        }
    }
}
