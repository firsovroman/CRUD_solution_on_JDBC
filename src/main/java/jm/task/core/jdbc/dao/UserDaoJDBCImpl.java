package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Statement statement;
    Util util;

    public UserDaoJDBCImpl() throws SQLException {
        util = Util.getInstance();
        try {
            statement = util.getConnection().createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void createUsersTable() {
        try {
            statement.executeUpdate("CREATE TABLE users (id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(40), lastName VARCHAR(40), age INT);");
        } catch (SQLSyntaxErrorException a) {
            System.out.println("Не удалось создать таблицу, таблица с таким именем уже существует");
        } catch (SQLException e){
            System.out.println("Не удалось создать таблицу");
        }
    }

    public void dropUsersTable() {
        try {
            statement.executeUpdate("DROP TABLE users;");
        } catch (SQLSyntaxErrorException a) {
            System.out.println("Не успешно, таблицы с таким названием не найдено");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу");
        }
    }

    public void saveUser(String name, String lastName, Integer age) {
        try {
            statement.executeUpdate("INSERT INTO users ( name, lastName , age ) " +
                    "VALUES ('"+ name + "', '"+lastName+"', '"+age+"');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            statement.executeUpdate("DELETE FROM users WHERE id='" + id +"';");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();

        try {
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
