package by.academy.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Month;

@Entity
@Table(name = "T_PAYSLIP")
public class Payslip {

    @Id
    @Column(name = "PAYSLIP_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column
    private BigDecimal amount;

    @Column
    private short year;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Month payslipMonth;

    public Payslip() {
    }

    public String getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public Month getPayslipMonth() {
        return payslipMonth;
    }

    public void setPayslipMonth(Month payslipMonth) {
        this.payslipMonth = payslipMonth;
    }
}
