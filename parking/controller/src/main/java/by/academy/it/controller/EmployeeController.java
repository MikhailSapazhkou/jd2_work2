package by.academy.it.controller;

import by.academy.it.company.Employee;
import by.academy.it.company.EmployeeDao;
import by.academy.it.company.PayslipDao;
import org.springframework.stereotype.Service;

@Service
public class EmployeeController {

    final EmployeeDao employeeDao;
    final PayslipDao payslipDao;

    public EmployeeController(EmployeeDao employeeDao, PayslipDao payslipDao) {
        this.employeeDao = employeeDao;
        this.payslipDao = payslipDao;
    }

    public boolean save(Employee employee) {
        //Check employee input value

        return employeeDao.saveEmployee(employee);
    }
}
