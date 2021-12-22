package by.academy.it.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "second_name", length = 500)
    private String secondName;

    @Id
    @Column(name = "id")
    private Long id;
}
