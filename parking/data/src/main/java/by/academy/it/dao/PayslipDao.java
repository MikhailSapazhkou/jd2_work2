package by.academy.it.dao;

import java.math.BigDecimal;

public interface PayslipDao {
    BigDecimal getAnnualSalary(String employeeId, short year);
}
