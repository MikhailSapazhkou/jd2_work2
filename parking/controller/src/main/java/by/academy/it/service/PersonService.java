package by.academy.it.service;

import by.academy.it.dao.AppParkingUserDao;
import by.academy.it.dao.PersonDao;
import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.pojo.AppParkingUser;
import by.academy.it.pojo.Person;
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

    public void addNewUser(AddNewUserCommand command) {
        AppParkingUser user = new AppParkingUser();
        Person person = new Person();

        person.setName(command.getName());
        person.setSecondName(command.getSecondName());
        saveNewPerson(person);

        user.setPerson(person);
        user.setAppParkingUserLogin(command.getLogin());
        user.setGetAppParkingUserPassword(command.getPassword());
        userDao.saveUser(user);

    }
}
