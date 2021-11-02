package by.academy.it.data;

import by.academy.it.pojo.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonDaoTest {

    PersonDao personDao;

    @Before
    public void setUp() throws Exception {
        personDao = new PersonDao();
    }

    @After
    public void tearDown() throws Exception {
        personDao = null;
    }

    @Test
    public void savePerson() {
        //Given
        Person person = new Person();
        person.setId(1001L);
        person.setName("Ivan");
        person.setSecondName("Petrov");

        //When
        Serializable id = personDao.savePerson(person);

        //Then
        assertEquals(1001L, id);
        List<Person> list = personDao.readPersons();
        assertEquals(1, list.size());
        personDao.deletePerson(list.get(0));
    }
}