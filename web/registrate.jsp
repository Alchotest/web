<%--
  Created by IntelliJ IDEA.
  User: alchotest
  Date: 05.04.2020
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registrate</title>
    <script>
        function checkInput() {
            reg.login.value = reg.login.value.trim();
            if (reg.login.value === ""){
                document.getElementById("esgMsg").innerHTML = "Account is empty";
                return false;
            }

            reg.submit();
        }
    </script>
</head>
<body>
<form name="reg" action="/registrate" method="post">
    Name: <input type="text" name="login"/><br/><br/>
    Password: <input type="password" name="password"/><br/><br/>
    <input type="submit" value="registrate"/>
</form>
</body>
</html>
