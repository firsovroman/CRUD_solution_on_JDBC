package firsov.core.jdbc;

import firsov.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
        UserServiceImpl usDa = new UserServiceImpl();


//        usDa.createUsersTable();
//        usDa.saveUser("Ivan", "Ivanov", 25);
//        usDa.saveUser("Petr", "Petrov", 25);
//        usDa.removeUserById(2);
//        usDa.cleanUsersTable();
//       List<User> list = usDa.getAllUsers();
//
//        for(User u : list){
//            System.out.println(u);
//        }


//        usDa.dropUsersTable();


    }
}
