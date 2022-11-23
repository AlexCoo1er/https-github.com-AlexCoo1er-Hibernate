package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {

    private static final String URL = "jdbc:mysql://127.0.0.1:3307/myfirstschema?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }
}
