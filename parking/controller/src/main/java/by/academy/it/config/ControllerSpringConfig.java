package by.academy.it.config;

import by.academy.it.company.EmployeeDao;
import by.academy.it.company.PayslipDao;
import by.academy.it.service.EmployeeService;
import by.academy.it.validator.EmployeeValidator;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Arrays;

@Getter
@Configuration("myFirstBean")
@ComponentScan(basePackages = "by.academy.it")
@PropertySource("classpath:/controller.properties")
public class ControllerSpringConfig {

    @Value("1.0")
    private Double id;

    @Value("${default.working.dir}")
    private String defaultWorkingDir;

    @Autowired
    private EmployeeService employeeController;

    @Autowired
    @Qualifier("employeeValidatorImpl")
    private EmployeeValidator employeeValidator;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(ControllerSpringConfig.class);
        context.refresh();

        System.out.println(context.getBeanDefinitionCount());
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        final ControllerSpringConfig myFirstBean = (ControllerSpringConfig) context.getBean("myFirstBean");
        System.out.println(myFirstBean);

        System.out.println("id=" + myFirstBean.getId());

        myFirstBean.getEmployeeValidator().validate(null);
        System.out.println("working dir: " + myFirstBean.getDefaultWorkingDir());
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDao();
    }

    @Bean
    public PayslipDao payslipDao() {
        return new PayslipDao();
    }
}
