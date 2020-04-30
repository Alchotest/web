<%@ page import="by.servlets.model.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: Alchotest
  Date: 24.04.2020
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets</title>
</head>
<body>
    <% User currentUser = (User) ( session.getAttribute("currentSessionUser"));%>
    <% if (currentUser == null) { %>
    <form name="ticket" method="post" action="/ticket">
        tickets:
        <input type="checkbox" disabled/>
        <input type="checkbox"disabled/>
        <input type="checkbox"disabled/>
        <input type="checkbox"disabled/>
        <input type="submit" value="ok" disabled>
    </form>
    <% } else if (currentUser.isValid()) {%>
    <form name="ticket" method="post" action="/ticket">
        tickets:
        <input type="checkbox" id="1" value="ticket1" name="ticketCheckBox"/>
        <input type="checkbox" id="2"value="ticket2"name="ticketCheckBox"/>
        <input type="checkbox" id="3"value="ticket3"name="ticketCheckBox"/>
        <input type="checkbox" id="4"value="ticket4"name="ticketCheckBox"/>
        <input type="submit" value="ok">
    </form>
    <% } %>
    <a href="index.jsp">back to main page</a>
</html>
