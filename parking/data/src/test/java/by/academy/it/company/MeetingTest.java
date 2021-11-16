package by.academy.it.company;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MeetingTest extends BaseTest {

    private static Meeting meeting(int count) {
        return new Meeting("Subject" + count, new Date());
    }

    public static Employee employee(int count) {
        return new Employee("Name" + count, "SecondName" + count, "+8029123456" + count);
    }

    public static void addEmployeesToMeeting(Meeting meeting, List<Employee> attendees) {
        for (Employee employee : attendees) {
            employee.getMeetings().add(meeting);
        }
        meeting.setAttendees(attendees);
    }

    @Test
    public void saveMeetings() {
        //Given
        Meeting meeting1 = meeting(1);
        Meeting meeting2 = meeting(2);
        Meeting meeting3 = meeting(3);

        Employee employee1 = employee(1);
        Employee employee2 = employee(2);
        Employee employee3 = employee(3);
        Employee employee4 = employee(4);
        Employee employee5 = employee(5);

        addEmployeesToMeeting(meeting1, List.of(employee1, employee2));
        addEmployeesToMeeting(meeting2, List.of(employee1, employee3));
        addEmployeesToMeeting(meeting3, List.of(employee2, employee4, employee5));

        //When
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        Serializable mId1 = session.save(meeting1);
        Serializable mId2 = session.save(meeting2);
        Serializable mId3 = session.save(meeting3);

        Serializable eId1 = session.save(employee1);
        Serializable eId2 = session.save(employee2);
        Serializable eId3 = session.save(employee3);
        Serializable eId4 = session.save(employee4);
        Serializable eId5 = session.save(employee5);
        transaction.commit();
        session.close();

        //Then
        Session newSession = sessionFactory.openSession();
        Meeting savedMeeting3 = newSession.get(Meeting.class, mId3);
        assertNotNull(savedMeeting3);
        assertEquals(3, savedMeeting3.getAttendees().size());
    }

}