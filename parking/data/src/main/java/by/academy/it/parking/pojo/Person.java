package by.academy.it.parking.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
public class Person implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "second_name", length = 500)
    private String secondName;

    @Id
    @Column(name = "id")
    private Long id;
}
