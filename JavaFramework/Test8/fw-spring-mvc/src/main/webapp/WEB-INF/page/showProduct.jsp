<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/22
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示添加的商品</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
商品ID：${product.id}<br>
商品名称：${requestScope.product.name}<br>
商品价格：${product.price}<br>
</body>
</html>
