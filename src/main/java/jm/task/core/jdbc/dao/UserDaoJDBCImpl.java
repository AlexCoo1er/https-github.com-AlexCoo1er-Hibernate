//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    private final Util util = new Util();
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String sql = """
//                CREATE TABLE IF NOT EXISTS `myfirstschema`.`Users` (
//                  `id` INT NOT NULL AUTO_INCREMENT,
//                  `name` VARCHAR(45) NOT NULL,
//                  `lastname` VARCHAR(45) NOT NULL,
//                  `age` INT(3) NOT NULL,
//                  PRIMARY KEY (`id`));""";
//        PreparedStatement preparedStatement = null;
//        try (Connection connection = util.getConnection()) {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void dropUsersTable() {
//        PreparedStatement preparedStatement = null;
//        String sql = "drop table if exists Users;";
//        try (Connection connection = util.getConnection()) {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "insert into Users (name, lastname, age) values (?,?,?);";
//        PreparedStatement preparedStatement = null;
//        try (Connection connection = util.getConnection()) {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setInt(3, age);
//            preparedStatement.executeUpdate();
//            connection.commit();
//            System.out.println("User с именем - " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void removeUserById(long id) {
//        PreparedStatement preparedStatement = null;
//        String sql = "delete from Users where id = ?;";
//        try (Connection connection = util.getConnection()) {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//            connection.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> list = new ArrayList<>();
//        String sql = "select * from Users;"; // добавление юзера
//        PreparedStatement preparedStatement = null;
//        try (Connection connection = util.getConnection()) {
//            preparedStatement = connection.prepareStatement(sql); // подготовка запроса на отправку
//            ResultSet resultSet = preparedStatement.executeQuery();//исполнение запроса отрпавка его в базу
//            while (resultSet.next()) {
//                list.add(new User(resultSet.getString("name"),
//                        resultSet.getString("lastname"),
//                        resultSet.getByte("age")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
//
//    public void cleanUsersTable() {
//        String sql = "truncate table Users;";
//        PreparedStatement preparedStatement = null;
//        try (Connection connection = util.getConnection()) {
//            preparedStatement = connection.prepareStatement(sql); // подготовка запроса на отправку
//            preparedStatement.executeUpdate(); //исполнение запроса отрпавка его в базу
//            connection.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

