package by.academy.it;

import by.academy.it.company.pojo.*;
import by.academy.it.parking.pojo.AppParkingUser;
import by.academy.it.parking.pojo.Person;
import by.academy.it.parking.pojo.Ticket;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:ds-test.properties")
@ComponentScan(basePackages = {"by.academy.it.company", "by.academy.it.parking"})
public class TestDaoConfiguration {

    @Autowired
    Environment env;

    @Bean
    public Properties dataSourceProperties() {
        Properties properties = new Properties();
        properties.setProperty("useSSL", env.getProperty("useSSL"));
        properties.setProperty("serverTimezone", env.getProperty("serverTimezone"));
        properties.setProperty("createDatabaseIfNotExist", env.getProperty("createDatabaseIfNotExist"));
        return properties;
    }


    @Bean
    public DataSource companyDataSource(Properties dataSourceProperties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("company.url"));
        config.setUsername(env.getProperty("company.user"));
        config.setPassword(env.getProperty("company.password"));
        config.setDriverClassName(env.getProperty("jdbc.driver"));
        config.setMaximumPoolSize(env.getProperty("company.pool_size", Integer.class));
        config.setDataSourceProperties(dataSourceProperties);
        return new HikariDataSource(config);
    }


    @Bean
    public DataSource parkingDataSource(Properties dataSourceProperties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("parking.url"));
        config.setUsername(env.getProperty("parking.user"));
        config.setPassword(env.getProperty("parking.password"));
        config.setDriverClassName(env.getProperty("jdbc.driver"));
        config.setMaximumPoolSize(env.getProperty("parking.pool_size", Integer.class));
        config.setDataSourceProperties(dataSourceProperties);
        return new HikariDataSource(config);
    }

    @Bean
    public LocalSessionFactoryBean companySessionFactory(
            @Qualifier("companyDataSource") DataSource dataSource) {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        sessionFactory.setHibernateProperties(properties);

        sessionFactory.setAnnotatedPackages("by.academy.it.company.pojo");
        sessionFactory.setAnnotatedClasses(Company.class,
                Employee.class, EmployeeDetails.class, Meeting.class, Payslip.class);

        return sessionFactory;
    }

    @Bean
    public LocalSessionFactoryBean parkingSessionFactory(
            @Qualifier("parkingDataSource") DataSource dataSource) {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("show_sql", "true");
        sessionFactory.setHibernateProperties(properties);

        sessionFactory.setAnnotatedPackages("by.academy.it.parking.pojo");
        sessionFactory.setAnnotatedClasses(AppParkingUser.class,
                Person.class, Ticket.class);

        return sessionFactory;
    }

}
