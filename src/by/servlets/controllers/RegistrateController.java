package by.servlets.controllers;

import by.servlets.consts.ConstantsJSP;
import by.servlets.exceptions.InitException;
import by.servlets.ifaces.UserDAO;
import by.servlets.model.factories.UserFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(
        urlPatterns = {"/registrate"},
        initParams = {
                @WebInitParam(name = "properties", value = "config")
        })
public class RegistrateController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(ConstantsJSP.LOGIN);
        String password = request.getParameter(ConstantsJSP.PASSWORD);
        UserDAO userDAO = UserFactory.getClassFromFactory();
        String error = "";
        try {
            userDAO.addUser(login, password);
        } catch (Exception e) {
            error += "&error=yes";
        }
        response.sendRedirect(request.getContextPath() + "/confirm.jsp?login=" + login + error);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
        try {
            String propertiesName = sc.getInitParameter("properties");
            ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
            UserFactory.init(rb);
        } catch (InitException e){
            throw new ServletException(e);
        }
    }
}
