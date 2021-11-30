package by.academy.it.controller;

import by.academy.it.config.ControllerSpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = ControllerSpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {

    @Autowired
    EmployeeController employeeController;

    @Test
    public void save() {
        assertNotNull(employeeController);
    }
}