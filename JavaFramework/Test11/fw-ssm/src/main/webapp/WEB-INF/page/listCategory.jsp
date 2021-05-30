<%@ page import="java.util.List" %>
<%@ page import="com.example.pojo.Category" %>
<%@ page import="com.example.util.Page" %>
<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/27
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类列表</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <th colspan="2">商品分类 Category 列表</th>
    </tr>
    <%
        // 获取 categoryList 参数，范围 requestScope
        List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");
        // 显示到表格
        for (Category c : categoryList) {
    %>
    <tr>
        <td><%= c.getId()%></td>
        <td><%= c.getName()%></td>
    </tr>
    <%}%>
</table>
<div style="text-align: center">
    <a href="?start=0">首页</a>
    <a href="?start=${page.start - page.count}">上一页</a>
    <a href="?start=${page.start + page.count}">下一页</a>
    <a href="?start=${page.last}">尾页</a>
</div>
<div style="text-align: center">
    添加分类：
    <form action="add" style="margin: 10px auto">
        <input type="text" name="name" placeholder="请输入分类名称">
        <input type="submit">
    </form>
</div>
</body>
</html>
