package by.academy.it.company;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.BeforeClass;

public class BaseTest {
    static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.company.cfg-test.xml")
                        .build();
        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }
}
