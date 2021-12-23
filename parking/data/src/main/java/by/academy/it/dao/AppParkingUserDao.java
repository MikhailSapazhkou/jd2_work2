package by.academy.it.dao;

import by.academy.it.pojo.AppParkingUser;

import java.util.List;

public interface AppParkingUserDao {

    List<AppParkingUser> searchByAppParkingUserLogin(String login);

    String findUserByPersonId(Long id);

    void saveUser(AppParkingUser user);
}
