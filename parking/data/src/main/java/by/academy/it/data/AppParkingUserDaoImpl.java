package by.academy.it.data;

import by.academy.it.dao.AppParkingUserDao;
import by.academy.it.pojo.AppParkingUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AppParkingUserDaoImpl implements AppParkingUserDao {

    private final SessionFactory sessionFactory;

    public AppParkingUserDaoImpl() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }

    @Override
    public List<AppParkingUser> searchByAppParkingUserLogin(String login) {
        return null;
    }

    @Override
    public String findUserByPersonId(Long id) {
        return null;
    }

    @Override
    public void saveUser(AppParkingUser user) {
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
