package by.academy.it.company;

import by.academy.it.data.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;

public class PayslipDao {
    private final SessionFactory sessionFactory;

    public PayslipDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactoryCompany();
    }

    public PayslipDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public BigDecimal getAnnualSalary(String employeeId, short year) {
        Session session = sessionFactory.openSession();
        final Query query = session.createQuery("SELECT SUM(p.amount) FROM Payslip p " +
                "WHERE p.employee.id=:employee_id AND p.year=:year");

        query.setParameter("employee_id", employeeId);
        query.setParameter("year", year);

        BigDecimal sum = (BigDecimal) query.uniqueResult();
        session.close();
        return sum;
    }
}
