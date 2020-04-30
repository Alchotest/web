package by.servlets.model.impl;

import by.servlets.db.ConstDb;
import by.servlets.db.ServiceDb;
import by.servlets.exceptions.InitException;
import by.servlets.ifaces.UserDAO;
import by.servlets.model.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImplDb implements UserDAO {

    private static List<User> users;

    public UserImplDb() throws InitException {
        users = new ArrayList<>();
        ServiceDb.init(ConstDb.DB_URL, ConstDb.PASSWORD, ConstDb.USER);
        try (Connection connection = ServiceDb.getConnection()){
            try (Statement st = connection.createStatement()){
                ResultSet rs = st.executeQuery(ConstDb.SELECT_USERS);
                while (rs.next()) {
                    users.add(new User(rs.getString(ConstDb.USER_LOGIN_INDEX), rs.getString(ConstDb.USER_PASSWORD_INDEX)));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(String login, String password) throws Exception {
        ServiceDb.init(ConstDb.DB_URL, ConstDb.PASSWORD, ConstDb.USER);
        try {
            Connection connection = ServiceDb.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(ConstDb.INSERT_USER);
                ps.setString(ConstDb.USER_LOGIN_INDEX,login);
                ps.setString(ConstDb.USER_PASSWORD_INDEX, password);
                ps.addBatch();
                ps.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getUserIdByUserLogin(String login) throws  InitException{
        ServiceDb.init(ConstDb.DB_URL, ConstDb.PASSWORD, ConstDb.USER);
        try {
            Connection connection = ServiceDb.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(ConstDb.SELECT_USER_ID_BY_LOGIN);
                ps.setString(ConstDb.USER_LOGIN_INDEX,login);
                ResultSet resultSet = ps.executeQuery();
                if(resultSet.next()){
                    return resultSet.getInt(1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return 0;
    }
}
