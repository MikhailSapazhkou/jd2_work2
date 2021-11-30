package by.academy.it.validator;

import by.academy.it.company.Employee;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class EmployeeValidatorImpl implements EmployeeValidator {
    @Override
    public boolean validate(Employee employee) {
        System.out.println("call EmployeeValidatorImpl");
        return false;
    }
}
