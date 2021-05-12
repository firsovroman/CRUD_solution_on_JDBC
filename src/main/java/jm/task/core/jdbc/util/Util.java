package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {  // Lazy Initialization

    private static Util INSTANCE;

    private static final String URL = "jdbc:mysql://localhost:3306/sys";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    private Util() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Connection successful");
        } catch (SQLException throwables) {
            System.out.println("Не удалось установить connection");
        }
    }

    public static Util getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Util();
        }
        return INSTANCE;
    }

    public Connection getConnection () {
        return connection;
    }

    public void closeConnection () throws SQLException {
        if(!connection.isClosed()) {
            connection.close();
            System.out.println("Connection закрыт");
        }
    }
}

