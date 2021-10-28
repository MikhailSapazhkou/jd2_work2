package by.academy.it.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryHolder {

    private static SessionFactory sessionFactory;

    public static Session getSession() {

        if (sessionFactory == null) {
            StandardServiceRegistry reg =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml") // hibernate-test.cfg.xml
                            .build();
            sessionFactory = new MetadataSources(reg)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

}
