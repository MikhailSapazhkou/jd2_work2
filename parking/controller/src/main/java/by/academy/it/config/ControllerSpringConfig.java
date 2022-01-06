package by.academy.it.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration("controllerConfiguration")
@ComponentScan(basePackages = {"by.academy.it.service",
        "by.academy.it.validator"})
@PropertySource("classpath:/controller.properties")
public class ControllerSpringConfig {

    @Value("${default.working.dir}")
    private String defaultWorkingDir;

}
