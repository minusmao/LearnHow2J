<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/14
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Session</title>
</head>
<body>
Session 里取出了 random: <%= session.getAttribute("random")%><br>
Session 的 ID 为: <%= session.getId()%>
</body>
</html>
