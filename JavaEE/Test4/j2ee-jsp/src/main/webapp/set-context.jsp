<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/14
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作用域</title>
</head>
<body>
<%--
    JSP有4个作用域，分别是
        pageContext 当前页面
        requestContext 一次请求
        sessionContext 当前会话
        applicationContext 全局，所有用户共享
--%>
<h4>Test1: pageContext 当前页面</h4>
<% pageContext.setAttribute("t1", "1111"); %>
设置了 t1: <%=pageContext.getAttribute("t1")%>

<h4>Test2: requestContext 一次请求</h4>
<%--
    常用写法：request.setAttribute("name","gareen");
            request.getAttribute("name");
    pageContext 写法：pageContext.setAttribute("name","gareen",pageContext.REQUEST_SCOPE);
                     pageContext.getAttribute("name",pageContext.REQUEST_SCOPE);

    服务端跳转、动作include，共享数据，因为属于同一个请求
--%>
<% request.setAttribute("t2", "2222"); %>
设置了 t2: <%= request.getAttribute("t2")%>

<h4>Test3: sessionContext 当前会话</h4>
<%--
    Session 对象，可通过 request.getSession() 获得，而在 JSP 中作为隐式对象（session），可直接调用
    常用写法：session.setAttribute("name","gareen");
            session.getAttribute("name");
    pageContext 写法：pageContext.setAttribute("name","gareen",pageContext.SESSION_SCOPE);
                     pageContext.getAttribute("name",pageContext.SESSION_SCOPE);

    同一个会话共享数据，可以实现购物车功能
--%>
<% session.setAttribute("t3", "3333"); %>
设置了 t3: <%= session.getAttribute("t3")%>

<h4>Test4: applicationContext 全局，所有用户共享</h4>
<%--
    application 对象是 ServletContext 接口的实例，可通过 request.getServletContext() 来获取，JSP 中作为隐式对象（application），可直接调用
    常用写法：application.setAttribute("name","gareen");
            application.getAttribute("name");
    pageContext 写法：pageContext.setAttribute("name","gareen",pageContext.APPLICATION_SCOPE);
                     pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE);

    全局共享
--%>
<% application.setAttribute("t4", "4444"); %>
设置了 t4: <%= application.getAttribute("t4")%>

<br>
<br>
<a href="get-context.jsp">转跳到 get-context.jsp 查看结果</a>
</body>
</html>
