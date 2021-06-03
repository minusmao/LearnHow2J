<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/6/1
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异常404</title>
</head>
<body>
<div style="width:500px;border:1px solid lightgray;margin:200px auto;padding:80px">
    系统 出现了异常，异常原因是：
    ${exception}
    <br><br>
    出现异常的地址是：
    ${url}
</div>
</body>
</html>
