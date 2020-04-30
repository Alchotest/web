package by.servlets.ifaces;

import by.servlets.model.beans.User;

import java.util.List;

public interface TicketDao {
    List<User> getTicket();
    void addTicket(int userId, String text) throws Exception;
}
