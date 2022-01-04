package by.academy.it.company;

import by.academy.it.company.pojo.Company;
import by.academy.it.dao.CompanySearchDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanySearchDao {

    @Autowired
    @Qualifier("companySessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Company> search(String namePattern) {
        Session session = sessionFactory.openSession();
        String query = "from Company c where c.companyName like '" + namePattern + "'";
        List<Company> companies = session.createQuery(query, Company.class).list();
        session.close();
        return companies;
    }
}
