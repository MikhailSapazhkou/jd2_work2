package by.academy.it.config;

import by.academy.it.company.CompanyDaoImpl;
import by.academy.it.company.EmployeeDao;
import by.academy.it.company.PayslipDao;
import by.academy.it.dao.AppParkingUserDao;
import by.academy.it.dao.CompanySearchDao;
import by.academy.it.dao.PersonDao;
import by.academy.it.dao.TicketDao;
import by.academy.it.data.AppParkingUserDaoImpl;
import by.academy.it.data.PersonDaoImpl;
import by.academy.it.data.TicketDaoImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration("controllerConfiguration")
@ComponentScan(basePackages = "by.academy.it")
@PropertySource("classpath:/controller.properties")
public class ControllerSpringConfig {

    @Value("${default.working.dir}")
    private String defaultWorkingDir;

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDao();
    }

    @Bean
    public PayslipDao payslipDao() {
        return new PayslipDao();
    }

    @Bean
    public AppParkingUserDao appParkingUserDao() {
        return new AppParkingUserDaoImpl();
    }

    @Bean
    public TicketDao ticketDao() throws ClassNotFoundException {
        return new TicketDaoImpl();
    }

    @Bean
    public PersonDao personDao() {
        return new PersonDaoImpl();
    }

    @Bean
    public CompanySearchDao companySearchDao() {
        return new CompanyDaoImpl();
    }
}
