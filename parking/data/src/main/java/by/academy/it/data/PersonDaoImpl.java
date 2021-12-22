package by.academy.it.data;

import by.academy.it.dao.PersonDao;
import by.academy.it.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private final SessionFactory sessionFactory;

    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonDaoImpl() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    @Override
    public Serializable savePerson(Person person) {
        Session session = sessionFactory.openSession();
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

    @Override
    public List<Person> readPersons() {
        Session session = sessionFactory.openSession();
        List<Person> personList =
                session.createQuery("from Person", Person.class).list();
        session.close();
        return personList;
    }

    @Override
    public void deletePerson(Person person) {
        Session session = sessionFactory.openSession();
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

    @Override
    public List<Person> searchByNameAndSecondName(String name, String secondName) {
        return null;
    }

}
