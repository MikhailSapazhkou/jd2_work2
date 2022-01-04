package by.academy.it.company.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_MEETING")
public class Meeting {

    @Id
    @Column(name = "MEETING_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    private String subject;

    private Date meetingDate;

    @ManyToMany(mappedBy = "meetings")
    private List<Employee> attendees;

    public Meeting() {
    }

    public Meeting(String subject, Date meetingDate) {
        this.subject = subject;
        this.meetingDate = meetingDate;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public List<Employee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Employee> attendees) {
        this.attendees = attendees;
    }
}
