package by.academy.it.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;

@Component
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public WebSecurityInitializer() {
        super(WebSecurityConfiguration.class);
    }
}
