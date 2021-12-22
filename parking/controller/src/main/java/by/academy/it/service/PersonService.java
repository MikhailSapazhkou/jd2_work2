package by.academy.it.service;

import by.academy.it.data.PersonDaoImpl;
import by.academy.it.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonDaoImpl personDao;

    public PersonService() {
        personDao = new PersonDaoImpl();
    }

    public List<String> saveNewPerson(Person person) {
        List<String> validationErrors = new ArrayList<>();
        //Validate input params
        if (person.getName() == null ||
                person.getName().isEmpty()) {
            validationErrors.add("Name is empty");
        }
        if (person.getId() == null) {
            person.setId(Math.round(Math.random() * 1000));
        }
        if (validationErrors.isEmpty()) {
            personDao.savePerson(person);
        }
        return validationErrors;
    }

    public List<Person> getAllPersons() {
        return personDao.readPersons();
    }
}
