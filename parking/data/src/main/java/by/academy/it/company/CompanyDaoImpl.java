package by.academy.it.company;

import by.academy.it.dao.CompanySearchDao;
import by.academy.it.data.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CompanyDaoImpl implements CompanySearchDao {

    private SessionFactory sessionFactory;

    public CompanyDaoImpl() {
        sessionFactory = SessionFactoryHolder.getSessionFactoryCompany();
    }

    @Override
    public List<Company> search(String namePattern) {
        Session session = sessionFactory.openSession();
        String query = "from Company c where c.companyName like '" + namePattern + "'";
        List<Company> companies = session.createQuery(query, Company.class).list();
        session.close();
        return companies;
    }
}
