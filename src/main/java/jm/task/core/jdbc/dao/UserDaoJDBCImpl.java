package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            String sql = """
                    CREATE TABLE IF NOT EXISTS `myfirstschema`.`Users` (
                      `id` INT NOT NULL AUTO_INCREMENT,
                      `name` VARCHAR(45) NOT NULL,
                      `lastname` VARCHAR(45) NOT NULL,
                      `age` INT(3) NOT NULL,
                      PRIMARY KEY (`id`));""";
            Connection connection = util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql); // подготовка запроса на отправку
            preparedStatement.execute(); //исполнение запроса отрпавка его в базу
        } catch (SQLException e) {
            throw new RuntimeException("Подключение к базе данных не удалось \n" + e);
        }
    }

    public void dropUsersTable() {
        try {
            String sql = "drop table if exists Users"; // добавление юзера
            Connection connection = util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql); // подготовка запроса на отправку
            preparedStatement.execute(); //исполнение запроса отрпавка его в базу
        } catch (SQLException e) {
            throw new RuntimeException("Подключение к базе данных не удалось \n" + e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            String sql = "insert into Users (name, lastname, age) values (?,?,?)"; // добавление юзера
            Connection connection = util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql); // подготовка запроса на отправку
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age); // подстановка вместо вопросов
            preparedStatement.execute(); //исполнение запроса отрпавка его в базу
            System.out.println("User с именем "+ name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException("Подключение к базе данных не удалось \n" + e);
        }

    }

    public void removeUserById(long id) {
        try {
            String sql = "delete from Users where id = ?"; // добавление юзера
            Connection connection = util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql); // подготовка запроса на отправку
            preparedStatement.setLong(1, id); // подстановка вместо вопросов
            preparedStatement.execute(); //исполнение запроса отрпавка его в базу
        } catch (SQLException e) {
            throw new RuntimeException("Подключение к базе данных не удалось \n" + e);
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            String sql = "select * from Users"; // добавление юзера
            Connection connection = util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql); // подготовка запроса на отправку
            ResultSet resultSet = preparedStatement.executeQuery();//исполнение запроса отрпавка его в базу
            while (resultSet.next()) {
                list.add(new User(resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getByte("age")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Подключение к базе данных не удалось \n" + e);
        }
        return list;
    }

    public void cleanUsersTable() {
        try {
            String sql = "delete from Users"; // добавление юзера
            Connection connection = util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql); // подготовка запроса на отправку
            preparedStatement.execute(); //исполнение запроса отрпавка его в базу
        } catch (SQLException e) {
            throw new RuntimeException("Подключение к базе данных не удалось \n" + e);
        }
    }
}
