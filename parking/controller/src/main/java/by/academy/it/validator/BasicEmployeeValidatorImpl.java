package by.academy.it.validator;

import by.academy.it.company.pojo.Employee;
import org.springframework.stereotype.Component;

@Component
public class BasicEmployeeValidatorImpl implements EmployeeValidator {
    @Override
    public boolean validate(Employee employee) {
        System.out.println("call BasicEmployeeValidatorImpl");
        return false;
    }
}
