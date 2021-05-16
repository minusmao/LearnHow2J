<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/16
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 获取请求的参数
    String name = request.getParameter("name");
    // 判断并存入 Session
    if(name != null) {
        session.setAttribute("name", name);
    }
%>
<html>
<head>
    <title>显示在线人数</title>
</head>
<body>
在线人数：${applicationScope.online_total}
<form method="get" action="total.jsp">
    <input type="text" name="name"><br>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>
