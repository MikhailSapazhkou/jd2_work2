package by.academy.it.data;

import by.academy.it.pojo.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDao {

    public void savePerson(Person person) {
        Session session = SessionFactoryHolder.getSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
        } finally {
            if (session != null) session.close();
        }
    }

}
