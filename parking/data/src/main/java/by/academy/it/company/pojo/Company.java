package by.academy.it.company.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_COMPANY")
public class Company {

    @Id
    @Column(name = "COMPANY_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    private String companyName;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
