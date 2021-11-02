package by.academy.it.data;

import by.academy.it.pojo.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class PersonDao {

    public Serializable savePerson(Person person) {
        Session session = SessionFactoryHolder.getSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public List<Person> readPersons() {
        Session session = SessionFactoryHolder.getSession();
        List<Person> personList =
                session.createQuery("from Person", Person.class).list();
        session.close();
        return personList;
    }

    public void deletePerson(Person person) {
        Session session = SessionFactoryHolder.getSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
