<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/14
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作用域</title>
</head>
<body>
<h4>Test1: pageContext 当前页面</h4>
读取 t1: <%= pageContext.getAttribute("t1")%>

<h4>Test2: requestContext 一次请求</h4>
读取 t2: <%= request.getAttribute("t2")%>

<h4>Test3: sessionContext 当前会话</h4>
读取 t3: <%= session.getAttribute("t3")%>

<h4>Test4: applicationContext 全局，所有用户共享</h4>
读取 t4: <%= application.getAttribute("t4")%>

</body>
</html>
