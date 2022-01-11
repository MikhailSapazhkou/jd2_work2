package by.academy.it.parking;

import by.academy.it.dao.PersonDao;
import by.academy.it.parking.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    @Autowired
    @Qualifier("parkingSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Serializable savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = null;
        try {
            id = session.save(person);
        } catch (Exception e) {
            e.printStackTrace();
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
    public Person readPerson(Long id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(person);
        } catch (Exception e) {
            e.printStackTrace();
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
