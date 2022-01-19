package by.academy.it.rest;

import by.academy.it.parking.pojo.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class PersonRestController {

    @GetMapping("/persons")
    public ResponseEntity<Person> getPerson() {
        Person person = new Person();
        person.setId(-1L);
        person.setName("Test1");
        person.setSecondName("Test2");
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
