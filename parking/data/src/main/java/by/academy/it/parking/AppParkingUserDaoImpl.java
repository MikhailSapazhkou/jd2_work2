package by.academy.it.parking;

import by.academy.it.dao.AppParkingUserDao;
import by.academy.it.parking.pojo.AppParkingUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppParkingUserDaoImpl implements AppParkingUserDao {

    @Autowired
    @Qualifier("parkingSessionFactory")
    private SessionFactory sessionFactory;

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
