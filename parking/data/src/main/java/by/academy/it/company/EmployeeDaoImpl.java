package by.academy.it.company;

import by.academy.it.company.pojo.Employee;
import by.academy.it.dao.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    @Qualifier("companySessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            session.save(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }
}
