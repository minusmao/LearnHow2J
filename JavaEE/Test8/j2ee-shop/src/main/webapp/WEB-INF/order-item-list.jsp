<%@ page import="com.example.dao.OrderItem" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/16
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单项列表</title>
  <!-- 使用 BootStrap 框架 -->
  <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
  <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
  <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
<table style="width:600px; margin:44px auto" class="table table-striped table-bordered table-hover table-condensed" align='center' border='1' cellspacing='0'>
  <tr>
    <td colspan="3" align="center">当前用户 [id:${user.id} name:${user.name}] 订单 [id: ${requestScope.order_id}]</td>
  </tr>
  <tr>
    <th>id</th>
    <th>product_id</th>
    <th>number</th>
  </tr>
  <% for(OrderItem orderItem : (List<OrderItem>)request.getAttribute("order_item_list")) { %>
  <tr>
    <td><%= orderItem.getId() %></td>
    <td><%= orderItem.getProductId() %></td>
    <td><%= orderItem.getNumber()%></td>
  </tr>
  <% } %>
</table>
</body>
</html>
