package firsov.core.jdbc.service;

import firsov.core.jdbc.dao.UserDao;
import firsov.core.jdbc.dao.UserDaoJDBCImpl;
import firsov.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoJDBCImpl();

    public UserServiceImpl() throws SQLException {
    }


    public void createUsersTable() throws SQLException {
        dao.createUsersTable();
    }

    public void dropUsersTable() {
        dao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, Integer age) {
        dao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        dao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public void cleanUsersTable() {
        dao.cleanUsersTable();
    }


}
