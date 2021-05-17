<%@ page import="com.example.dao.Product" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/16
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
  <!-- 使用 BootStrap 框架 -->
  <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
  <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
  <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
<table style="width:600px; margin:44px auto" class="table table-striped table-bordered table-hover table-condensed" align='center' border='1' cellspacing='0'>
  <tr>
    <td colspan="4" align="center">
      当前用户 [id:${user.id} name:${user.name}] &nbsp; &nbsp;
      <a href="OrderListServlet">历史订单>></a>
    </td>
  </tr>
  <tr>
    <th>id</th>
    <th>name</th>
    <th>price</th>
    <th>buy</th>
  </tr>
  <% for(Product product : (List<Product>)request.getAttribute("product_list")) { %>
  <tr>
    <td><%= product.getId() %></td>
    <td><%= product.getName() %></td>
    <td><%= product.getPrice() %></td>
    <td>
      <form method="post" action="ShoppingCarServlet" style="margin: 0px">
        <input type="hidden" name="product_id" value="<%= product.getId()%>">
        <input type="text" name="number">
        <input type="submit" value="添加">
      </form>
    </td>
  </tr>
  <% } %>
</table>
</body>
</html>
