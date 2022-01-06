package by.academy.it.config;

import by.academy.it.dao.*;
import lombok.Getter;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@ComponentScan(basePackages = {"by.academy.it.service",
        "by.academy.it.validator"})
@PropertySource("classpath:/controller.properties")
public class TestControllerSpringConfig {

    @Mock
    EmployeeDao employeeDao;
    @Mock
    PayslipDao payslipDao;
    @Mock
    PersonDao personDao;
    @Mock
    AppParkingUserDao appParkingUserDao;
    @Mock
    CompanySearchDao companySearchDao;
    @Mock
    TicketDao ticketDao;
    @Value("${default.working.dir}")
    private String defaultWorkingDir;

    public TestControllerSpringConfig() {
        MockitoAnnotations.initMocks(this);
    }

    @Bean
    public EmployeeDao employeeDao() {
        return employeeDao;
    }

    @Bean
    public PayslipDao payslipDao() {
        return payslipDao;
    }

    @Bean
    public PersonDao personDao() {
        return personDao;
    }

    @Bean
    public AppParkingUserDao appParkingUserDao() {
        return appParkingUserDao;
    }

    @Bean
    public CompanySearchDao companySearchDao() {
        return companySearchDao;
    }

    @Bean
    public TicketDao ticketDao() {
        return ticketDao;
    }
}
