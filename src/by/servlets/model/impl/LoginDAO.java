package by.servlets.model.impl;

import by.servlets.db.ConstDb;
import by.servlets.db.ServiceDb;
import by.servlets.exceptions.InitException;
import by.servlets.model.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public static boolean validate(String login, String password) throws InitException {
        boolean status = false;
        ServiceDb.init(ConstDb.DB_URL,ConstDb.USER, ConstDb.PASSWORD);
        try {
            Connection connection = ServiceDb.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(ConstDb.SELECT_USER)){
                ps.setString(ConstDb.USER_LOGIN_INDEX, login);
                ps.setString(ConstDb.USER_PASSWORD_INDEX, password);
                ps.executeQuery();
                ResultSet rs = ps.executeQuery();
                status = rs.next();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static User login(User user) throws InitException {
        if(validate(user.getLogin(), user.getPass())){
            user.setValid(true);
        }
        return user;
    }
}
