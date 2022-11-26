package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Sasha ", "Kulishov ", (byte)23);
        userService.saveUser("Masha ", "Shubina ", (byte)23);
        userService.saveUser("Timur ", "Belokobilskiy ", (byte)23);
        userService.saveUser("Nastya ","Ivanova", (byte)23);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
