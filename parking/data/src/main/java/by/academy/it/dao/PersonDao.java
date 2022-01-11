package by.academy.it.dao;

import by.academy.it.parking.pojo.Person;

import java.io.Serializable;
import java.util.List;

public interface PersonDao {

    Serializable savePerson(Person person);

    List<Person> readPersons();

    Person readPerson(Long id);

    void deletePerson(Person person);

    List<Person> searchByNameAndSecondName(String name, String secondName);

    List<Person> search(String param);
}
