package by.academy.it.parking;

import by.academy.it.config.TestDaoConfiguration;
import by.academy.it.dao.PersonDao;
import by.academy.it.parking.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = TestDaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDaoImplTest {

    @Autowired
    private PersonDao personDaoImpl;

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