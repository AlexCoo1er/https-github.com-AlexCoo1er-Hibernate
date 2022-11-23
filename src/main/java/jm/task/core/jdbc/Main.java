package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();
        UserService userService = new UserServiceImpl(userDao);
        userService.createUsersTable();
        userService.saveUser("sasha ", "Kamen ", (byte)23);
        userService.getAllUsers().forEach(System.out::println);
        //userService.removeUserById(4);
        //userService.cleanUsersTable();

    }
}
