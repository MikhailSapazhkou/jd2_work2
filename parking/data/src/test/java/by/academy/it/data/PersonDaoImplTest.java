package by.academy.it.data;

import by.academy.it.pojo.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonDaoImplTest {

    static SessionFactory sessionFactory;
    PersonDaoImpl personDaoImpl;

    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.parking.cfg-test.xml") // hibernate-test.cfg.xml
                        .build();
        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
        personDaoImpl = new PersonDaoImpl(sessionFactory);
    }

    @After
    public void tearDown() throws Exception {
        personDaoImpl = null;
    }

    @Test
    public void savePerson() {
        //Given
        Person person = new Person();
        person.setId(1001L);
        person.setName("Ivan");
        person.setSecondName("Petrov");

        //When
        Serializable id = personDaoImpl.savePerson(person);

        //Then
        assertEquals(1001L, id);
        List<Person> list = personDaoImpl.readPersons();
        assertEquals(1, list.size());
        personDaoImpl.deletePerson(list.get(0));
    }
}