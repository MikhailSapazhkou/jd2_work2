package by.academy.it.dao;

import by.academy.it.pojo.Person;

import java.io.Serializable;
import java.util.List;

public interface PersonDao {

    Serializable savePerson(Person person);

    List<Person> readPersons();

    void deletePerson(Person person);

    List<Person> searchByNameAndSecondName(String name, String secondName);
}
