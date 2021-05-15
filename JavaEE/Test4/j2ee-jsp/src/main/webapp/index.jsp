<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%
    List<String> wordList = new ArrayList<>();
    wordList.add("today");
    wordList.add("is");
    wordList.add("a");
    wordList.add("great");
    wordList.add("day");
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--
  <%= "hello" %> 等效于 <% out.println("hello"); %>;
  其中 out = response.getWriter();
--%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a><br>
<%= new Date().toString() %><br>

<%-- 使用 for 循环 --%>
<table width="200px" border="1" cellspacing="0">
<% for(String word : wordList) { %>
    <tr>
        <td><%= word %></td>
    </tr>
<% } %>
</table>
<%-- 指令 include，会将信息一起写入对应 Servlet 中，可直接访问本页面参数 --%>
<%-- <%@include file="footer.jsp"%> --%>
<%-- 动作 include，服务器自己访问该 jsp 再转发给客户端，可通过 jsp:param 传递参数 --%>
<jsp:include page="footer.jsp">
    <jsp:param name="year" value="2021"/>
</jsp:include>
<a href="jump.jsp">jump.jsp</a><br>
<a href="set-cookie.jsp">set-cookie.jsp</a><br>
<a href="set-session.jsp">set-session.jsp</a><br>
<a href="get-session.jsp">get-session.jsp</a><br>
<a href="set-context.jsp">set-context.jsp</a><br>
<a href="el-test.jsp?name=abc">el-test.jsp?name=abc</a><br>

<%--
    JSP 隐式对象
        request 代表请求
        response 代表响应
        out 代表 输出

        pageContext 代表当前页面作用域
        session 代表当会话作用域
        application 代表当全局作用域

        page 表示当前 Sevlet 对象，等同于在页面中使用 this
        config 可以获取一些在web.xml中初始化的参数
               在 Servlet 中可以调用 this.getServletConfig() 获得，也可直接调用 this.getInitParameter() 获得初始参数
        exception 错误页面可以使用的对象，存储了别的页面发生的某种错误
--%>
<%-- page 表示当前 Sevlet 对象，等同于在页面中使用 this --%>
page: <%= page%><br>
this: <%= this%><br>
<%-- config 可以获取一些在web.xml中初始化的参数：测试此功能，需要在 web.xml 中配置 <init-param> --%>
测试 config 对象: <%= config.getInitParameter("conf-test")%><br>
不需要 config 对象也行: <%= getInitParameter("conf-test")%>

<%--
exception 对象只有当前页面的<%@page 指令设置为isErrorPage="true"的时候才可以使用。
同时，在其他页面也需要设置 <%@page 指令 errorPage="" 来指定一个专门处理异常的页面
--%>
</body>
</html>