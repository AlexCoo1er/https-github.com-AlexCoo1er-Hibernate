package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();
        UserService userService = new UserServiceImpl(userDao);
        User user = new User();
        userService.createUsersTable();
        userService.saveUser("Sasha ", "Kulishov ", (byte)23);
        userService.saveUser("Masha ", "Shubina ", (byte)23);
        userService.saveUser("Timur ", "Belokobilskiy ", (byte)23);
        userService.saveUser("Nastya ", "Ivanova ", (byte)23);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
