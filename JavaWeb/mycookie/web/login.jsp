<%--
  Created by IntelliJ IDEA.
  User: lianxing
  Date: 2021/10/22
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/mycookie/loginServlet" method="get">
        用户名：<input type="text" name="username" value="${cookie.username.value}" > <br>
        密码:  <input type="text" name="password" > <br>
        <input type="submit" name="submit" >
    </form>
</body>
</html>
