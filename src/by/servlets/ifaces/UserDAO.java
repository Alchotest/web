package by.servlets.ifaces;

import by.servlets.exceptions.InitException;
import by.servlets.model.beans.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();

    void addUser(String login, String password) throws Exception;

    int getUserIdByUserLogin(String login) throws InitException;


}
