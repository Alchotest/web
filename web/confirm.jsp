<%@ page import="by.servlets.model.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: alchotest
  Date: 05.04.2020
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>confirm</title>
</head>
<body>
<% User currentUser = (User) ( session.getAttribute("currentSessionUser"));%>
    <% if (currentUser.isValid()){ %>
Welcome <%= currentUser.getLogin() + " "  %>
    <% } %>
<%--${param.login}, your account has--%>
<%--<c:if test="${not empty param.error}">--%>
<%--    not--%>
<%--</c:if>--%>
<%--been registered!--%>
<br/>
<c:if test="${not empty param.error}">
    <p style="color: red">
        Some problems with data source on the server ...
    </p>
</c:if>
<a href="index.jsp">main</a>
</body>
</html>
