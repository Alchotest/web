package by.servlets.controllers;

import by.servlets.consts.ConstantsJSP;
import by.servlets.model.beans.User;
import by.servlets.model.impl.LoginDAO;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@javax.servlet.annotation.WebServlet("/login")
public class LoginController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String login = request.getParameter(ConstantsJSP.LOGIN);
        String password = request.getParameter(ConstantsJSP.PASSWORD);
        User user = new User(password, login, false);

        User login1 = LoginDAO.login(user);
        if(login1.isValid()){
//            response.sendRedirect(request.getContextPath()+"/index.jsp?login="+login);
            HttpSession session = request.getSession(true);
            session.setAttribute("currentSessionUser", login1);
            response.sendRedirect("confirm.jsp"); //logged-in page
        }
        else{
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
