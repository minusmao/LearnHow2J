<%@ page import="com.example.dao.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/16
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单列表</title>
    <!-- 使用 BootStrap 框架 -->
    <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
<table style="width:600px; margin:44px auto" class="table table-striped table-bordered table-hover table-condensed" align='center' border='1' cellspacing='0'>
    <tr>
        <td colspan="3" align="center">当前用户 [id:${user.id} name:${user.name}]</td>
    </tr>
    <tr>
        <th>id</th>
        <th>create_time</th>
        <th>open</th>
    </tr>
    <% SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    // 格式化时间类 %>
    <% for(Order order : (List<Order>)request.getAttribute("order_list")) { %>
    <tr>
        <td><%= order.getId() %></td>
        <td><%= dateFormat.format(order.getCreatTime()) %></td>
        <td><a href="OrderItemListServlet?order_id=<%= order.getId()%>">查看</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
