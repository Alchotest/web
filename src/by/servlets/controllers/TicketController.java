package by.servlets.controllers;

import by.servlets.model.beans.User;
import by.servlets.model.impl.TicketDbImpl;
import by.servlets.model.impl.UserImplDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ticket")
public class TicketController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User currentSessionUser = (User) request.getSession().getAttribute("currentSessionUser");
        UserImplDb userImplDb = new UserImplDb();
        int userIdByUserLogin = userImplDb.getUserIdByUserLogin(currentSessionUser.getLogin());

        TicketDbImpl ticketDb = new TicketDbImpl();

        String[] ticketCheckBoxes = request.getParameterValues("ticketCheckBox");
        System.out.println(userIdByUserLogin);
        for (String ticketCheckBox : ticketCheckBoxes) {
            try {
                ticketDb.addTicket(userIdByUserLogin, ticketCheckBox);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
