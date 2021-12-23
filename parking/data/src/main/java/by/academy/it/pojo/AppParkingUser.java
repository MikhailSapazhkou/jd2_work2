package by.academy.it.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "app_parking_users")
@Getter
@Setter
public class AppParkingUser {

    @Id
    @Column(name = "APP_PARKING_USER_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "USER_LOGIN", nullable = false)
    private String appParkingUserLogin;

    @Column(name = "USER_PASSWORD", nullable = true)
    private String getAppParkingUserPassword;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
