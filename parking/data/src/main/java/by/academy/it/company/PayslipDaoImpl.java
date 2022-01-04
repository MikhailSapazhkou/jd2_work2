package by.academy.it.company;

import by.academy.it.dao.PayslipDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class PayslipDaoImpl implements PayslipDao {

    @Autowired
    @Qualifier("companySessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public BigDecimal getAnnualSalary(String employeeId, short year) {
        Session session = sessionFactory.openSession();
        session.getCriteriaBuilder();

        final Query query = session.createQuery("SELECT SUM(p.amount) FROM Payslip p " +
                "WHERE p.employee.id=:employee_id AND p.year=:year");

        query.setParameter("employee_id", employeeId);
        query.setParameter("year", year);

        BigDecimal sum = (BigDecimal) query.uniqueResult();
        session.close();
        return sum;
    }
}
