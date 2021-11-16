package by.academy.it.company;

import by.academy.it.data.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDao {

    private SessionFactory sessionFactory;

    public EmployeeDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactoryCompany();
    }


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
