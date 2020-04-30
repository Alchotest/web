package by.servlets.model.impl;

import by.servlets.db.ConstDb;
import by.servlets.db.ServiceDb;
import by.servlets.ifaces.TicketDao;
import by.servlets.model.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TicketDbImpl implements TicketDao {


    @Override
    public List<User> getTicket() {
        return null;
    }

    @Override
    public void addTicket(int userId, String text) throws Exception {
        ServiceDb.init(ConstDb.DB_URL, ConstDb.PASSWORD, ConstDb.USER);
        try {
            Connection connection = ServiceDb.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(ConstDb.INSERT_TICKET);
                ps.setString(1, String.valueOf(userId));
                ps.setString(2, text);
                ps.addBatch();
                ps.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
