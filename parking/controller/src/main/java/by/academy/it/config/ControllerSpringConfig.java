package by.academy.it.config;

import by.academy.it.company.EmployeeDao;
import by.academy.it.company.PayslipDao;
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
}
