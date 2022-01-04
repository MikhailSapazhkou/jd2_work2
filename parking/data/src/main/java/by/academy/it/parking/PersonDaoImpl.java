package by.academy.it.parking;

import by.academy.it.dao.PersonDao;
import by.academy.it.parking.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    @Qualifier("parkingSessionFactory")
    private SessionFactory sessionFactory;

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
        Session session = sessionFactory.openSession();
        List<Person> personList =
                session.createQuery("from Person p where p.name=:name and p.secondName=:secondName ", Person.class)
                        .setParameter("name", name)
                        .setParameter("secondName", secondName)
                        .list();
        session.close();
        return personList;
    }

    @Override
    public List<Person> search(String param) {
        Session session = sessionFactory.openSession();
        List<Person> personList =
                session.createQuery("from Person p where p.name like '%" + param +
                                "%' or p.secondName like '%" + param + "%' ", Person.class)
                        .list();
        session.close();
        return personList;
    }

}
