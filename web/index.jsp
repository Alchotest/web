<%@ page import="by.servlets.model.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: alchotest
  Date: 07.03.2020
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>main page</title>
</head>
<body>
<% User currentUser = (User) (session.getAttribute("currentSessionUser"));%>
    User:
    <% if (currentUser == null) { %>
    guest:<br/>
    <button>
        <a href="login.jsp">Login</a><br/>
    </button>
    <button>
        <a href="registrate.jsp">Registrate</a>
    </button>
    <% } else if (currentUser.isValid()) {%>
        <%= currentUser.getLogin() + " "  %>
<form name="logout" action="/logout" method="post">
        <button type="submit">
            Logout
        </button>
</form>
    <% } %>

    <br/><button>
    <a href="ticketForm.jsp">ticket</a>
</button>


</body>
</html>
