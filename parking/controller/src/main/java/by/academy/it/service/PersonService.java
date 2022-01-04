package by.academy.it.service;

import by.academy.it.dao.AppParkingUserDao;
import by.academy.it.dao.PersonDao;
import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.parking.pojo.AppParkingUser;
import by.academy.it.parking.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private AppParkingUserDao userDao;

    public List<String> saveNewPerson(Person person) {
        List<String> validationErrors = new ArrayList<>();
        //Validate input params
        if (person.getName() == null ||
                person.getName().isEmpty()) {
            validationErrors.add("Name is empty");
        }
        if (person.getSecondName() == null || person.getSecondName().isEmpty()) {
            validationErrors.add("Second name is empty");
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

    public List<String> addNewUser(AddNewUserCommand command) {
        AppParkingUser user = new AppParkingUser();
        Person person = new Person();

        person.setName(command.getName());
        person.setSecondName(command.getSecondName());
        List<String> errors = saveNewPerson(person);

        if (errors.isEmpty()) {
            user.setPerson(person);
            user.setAppParkingUserLogin(command.getLogin());
            user.setGetAppParkingUserPassword(command.getPassword());
            userDao.saveUser(user);
        }
        return errors;
    }

    public Person findPerson(String name, String secondName) {
        return personDao.searchByNameAndSecondName(name, secondName).get(0);
    }
}
