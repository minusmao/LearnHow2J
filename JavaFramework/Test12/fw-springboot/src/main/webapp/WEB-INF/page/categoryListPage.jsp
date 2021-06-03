<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/6/2
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>商品分类列表</title>
</head>
<body>
<div style="width:500px;border:1px solid lightgray;margin:100px auto;padding:80px">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>delete</th>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="delete?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <div align='center'>
        <a href="?start=1">[首页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[尾页]</a>
    </div>
    <div align='center'>
        <h4>增加分类</h4>
        <form action="add" method="post">
            <input type="text" name="name" placeholder="请输入名称">
            <input type="submit" value="提交">
        </form>
    </div>
    <div align="center">
        <h4>更新数据</h4>
        <form action="update" method="post">
            <input type="number" name="id" placeholder="请输入ID">
            <input type="text" name="name" placeholder="请输入名称">
            <input type="submit" value="提交">
        </form>
    </div>
</div>
</body>
</html>
