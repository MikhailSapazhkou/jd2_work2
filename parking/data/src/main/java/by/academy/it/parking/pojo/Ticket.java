package by.academy.it.parking.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket implements Serializable {
    @Column(name = "car_number")
    private String licensePlateNumber;

    @Column(name = "ticket_date")
    private Date date;

    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
