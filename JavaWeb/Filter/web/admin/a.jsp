<%--
  Created by IntelliJ IDEA.
  User: lianxing
  Date: 2021/10/24
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>Title
<body>
    <%
        Object user = session.getAttribute("user");
        // 如果等于 null，说明还没有登录
        if (user == null) {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
        }

    %>


  这是a.jsp文件
</body>
</html>
