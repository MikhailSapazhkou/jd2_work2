package by.academy.it.controller;

import by.academy.it.company.Employee;
import by.academy.it.company.EmployeeDao;

public class EmployeeController {

    EmployeeDao employeeDao = new EmployeeDao();

    public boolean save(Employee employee) {
        //Check employee input value

        return employeeDao.saveEmployee(employee);
    }
}
