package by.academy.it.company;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeTest extends BaseTest {

    @Test
    public void testSave() throws InterruptedException {
        //Given
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Employee employee = new Employee("Ivan", "Petrov", "+375295554433");
        EmployeeDetails details = new EmployeeDetails("Lenina 21, Minsk");
        employee.setEmployeeDetails(details);
        details.setEmployee(employee);

        //When
        Serializable id = session.save(employee);
        //session.save(details);
        tr.commit();

        //Then
        Employee saved = session.get(Employee.class, id);
        System.out.println(saved.getId());
        assertNotNull(saved.getId());
        assertNotNull(saved.getEmployeeDetails().getId());
    }

    @Test
    public void saveCompanyWithEmployees() {
        //Given
        Company company = new Company("Coca-Cola");
        Employee employee1 = new Employee("First", "First", "+11111");
        Employee employee2 = new Employee("Second", "Second", "+22222");
        employee1.setCompany(company);
        employee2.setCompany(company);

        //When
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Serializable companyId = session.save(company);
        session.save(employee1);
        session.save(employee2);
        tr.commit();

        //Then
        Company saved = session.get(Company.class, companyId);
        assertEquals(2, saved.getEmployees().size());
    }

}