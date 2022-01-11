package by.academy.it.rest;


import by.academy.it.dao.PersonDao;
import by.academy.it.parking.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPerson(
            @PathVariable("id") Long id) {
        Person person = personDao.readPerson(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons() {
        final List<Person> people = personDao.readPersons();
        if (people.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        System.out.println("Called savePerson: " + person);
        final Serializable personId = personDao.savePerson(person);
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        final Person savedPerson = personDao.readPerson((Long) personId);
        if (savedPerson == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        Person person = personDao.readPerson(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personDao.deletePerson(person);
        return new ResponseEntity<>(person, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person newPerson,
                                               @PathVariable("id") Long id) {
        /*final Person savedPerson = personDao.readPerson(id);

        boolean needUpdate = false;
        if (newPerson.getName() != null &&
                !savedPerson.getName().equals(newPerson.getName())) {
            needUpdate = true;
        }
        if (needUpdate) {
            personDao.updatePerson()
        }*/
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }


}
