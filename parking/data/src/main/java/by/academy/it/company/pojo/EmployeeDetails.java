package by.academy.it.company.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_EMPLOYEE_DETAILS")
public class EmployeeDetails {

    @Id
    @Column(name = "EMPLOYEE_DETAILS_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String address;
    @OneToOne
    private Employee employee;

    public EmployeeDetails() {
    }

    public EmployeeDetails(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
