package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        UserServiceImpl usDa = new UserServiceImpl();
        //usDa.createUsersTable();
        //usDa.saveUser("Ivan", "Ivanov", 25);
        //usDa.saveUser("Petr", "Petrov", 25);
        //usDa.removeUserById(1);
        //usDa.cleanUsersTable();
/*        List<User> list = usDa.getAllUsers();

        for(User u : list){
            System.out.println(u);
        }*/
        //usDa.dropUsersTable();


    }
}
