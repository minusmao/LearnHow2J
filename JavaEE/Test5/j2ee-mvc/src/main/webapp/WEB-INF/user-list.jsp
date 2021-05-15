<%@ page import="com.example.dao.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/15
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>遍历 User</title>
    <!-- 使用 BootStrap 框架 -->
    <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script>
        $(function(){
            $("a").addClass("btn btn-default btn-xs");    // 给超链接加载样式
        });
    </script>
</head>
<body>
<table style="width:600px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
    <tr>
        <td colspan="7" align="center">当前用户id: ${sessionScope.login_id}</td>
    </tr>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>sex</th>
        <th>country</th>
        <th>signature</th>
        <th>delete</th>
    </tr>
    <% for(User user : (List<User>)request.getAttribute("userList")) { %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getPassword() %></td>
        <td><%= user.getSex().getName() %></td>
        <td><%= user.getCountry() %></td>
        <td><%= user.getSignature() %></td>
        <td><a href="user-delete-servlet?delete_id=<%= user.getId()%>">删除</a></td>
    </tr>
    <% } %>
    <tr align="center">
        <td colspan="7">
            <a href="user-list-servlet?begin=${pre}">上一页</a>&nbsp;
            <a href="user-list-servlet?begin=${next}">下一页</a>
        </td>
    </tr>
</table>
</body>
</html>
