package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    
    Connection conn;

    public UserDaoJDBCImpl() throws SQLException {
        Util util = Util.getInstance();
        conn = util.getConnection();
    }

    public void createUsersTable() {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE users (id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(40), lastName VARCHAR(40), age INT);");
        } catch (SQLSyntaxErrorException a) {
            System.out.println("Не удалось создать таблицу, таблица с таким именем уже существует");
        } catch (SQLException e){
            System.out.println("Не удалось создать таблицу");
        }
    }

    public void dropUsersTable() {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE users;");
        } catch (SQLSyntaxErrorException a) {
            System.out.println("Не успешно, таблицы с таким названием не найдено");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу");
        }
    }

    public void saveUser(String name, String lastName, Integer age) {
        try {
            String sql = "INSERT INTO users ( name, lastName , age ) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("%d rows added", rows);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            String sql = "DELETE FROM users WHERE id=?;";
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql);
            preparedStatement2.setLong(1, id);

            int rows2 = preparedStatement2.executeUpdate();

            System.out.printf("%d rows added", rows2);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM users");

            while(resultset.next()) {
                Long id1 = resultset.getLong("id");
                String name1 = resultset.getString("name");
                String lastname1 = resultset.getString("lastName");
                Integer age1 = resultset.getInt("age");

                list.add(new User(id1, name1, lastname1, age1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("TRUNCATE TABLE users;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

/*    public void closeConnection() {
        try {
            util.closeConnection();
        } catch (SQLException throwables) {
            System.out.println("Закрыть connection не удалось");
        }
    }*/
}
