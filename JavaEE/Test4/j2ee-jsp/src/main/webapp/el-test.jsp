<%@ page import="com.example.j2ee_jsp.Hero" %><%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/15
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL 表达式</title>
</head>
<body>
<%
    // EL 表达式参考连接：https://blog.csdn.net/w_linux/article/details/79850223
    pageContext.setAttribute("name", 1111);    // 页面范围
    request.setAttribute("name", 2222);    // 请求范围
    session.setAttribute("name", 3333);    // 会话范围
    application.setAttribute("name", 4444);    // 全局范围

    // 访问 JavaBean 需要先存入
    Hero hero = new Hero();
    hero.setName("galen");
    hero.setHp(100);
    request.setAttribute("h", hero);
%>
EL 表达式取出数据的优先级 pageContext > request > session > application<br>
${name}<br>
${pageScope.name}<br>
${requestScope.name}<br>
${sessionScope.name}<br>
${applicationScope.name}<br>

EL 表达式取出提交的参数<br>
${param.name}<br>
<%-- 等同于 --%>
<%= request.getParameter("name")%><br>

EL 表达式取出 web.xml 配置的参数（全局）<br>
${initParam.name}<br>
<%-- 等同于（其中 application = request.getServletContext()） --%>
<%= application.getInitParameter("name")%><br>

EL 表达式取出 JavaBean 的属性<br>
${h.name}<br>
${h.hp}<br>
</body>
</html>
