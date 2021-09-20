<%--
  Created by IntelliJ IDEA.
  User: zs
  Date: 2021/9/16
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="http://localhost:8080/Servlet/request" method="post">
      用户名<input type="text" name="username">
      密码<input type="text" name="password"> <br/>
      兴趣爱好：
      Java<input type="checkbox" name="hobby" value="Java">
      cpp<input type="checkbox" name="hobby" value="cpp">


      <input type="submit">

    </form>
  </body>
</html>
