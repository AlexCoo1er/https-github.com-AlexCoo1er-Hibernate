package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUsersTable() {
        if (userDao == null) return;
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        if (userDao == null) return;
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        if (userDao == null) return;
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        if (userDao == null) return;
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        if (userDao == null) return null;
        return userDao.getAllUsers();

    }

    public void cleanUsersTable() {
        if (userDao == null) return;
        userDao.cleanUsersTable();
    }
}
