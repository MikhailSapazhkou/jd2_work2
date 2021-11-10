package by.academy.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    private String firstName;
    private String secondName;
    private String phoneNumber;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    public Employee() {
    }

    public Employee(String firstName, String secondName, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
