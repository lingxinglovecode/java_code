<%--
  Created by IntelliJ IDEA.
  User: lianxing
  Date: 2021/9/20
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
    %>

    <%=i%> * <%=j%> = <%=i*j%>
    <%
        }
    %>
    <br>
    <%
        }
    %>



</body>
</html>
