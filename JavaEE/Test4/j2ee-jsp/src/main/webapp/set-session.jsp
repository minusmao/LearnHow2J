<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/14
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Session</title>
</head>
<body>
<%--
    Session 用于服务端存储一次会话的临时数据，不同客户端都有一个 SESSIONID 的 Cookie，用于区分不同的会话
    每一个会话都有一个对应的 Session 对象，通过 request.getSession() 获得，而在 JSP 中作为隐式对象（session），可直接调用
    Tamcat 默认判定为一个会话：30 分钟之内至少请求一次，且浏览器不能关闭（关闭后也代表会话结束）

    SESSIONID 可通过 session.getId() 获得，也可以通过获取 Cookie 的方式获得
--%>
<%
    session.setAttribute("random", Math.random()*100);    // 存一个随机数到 Session 里
%>
Session 里存入了 random: <%= session.getAttribute("random")%><br>
Session 的 ID 为: <%= session.getId()%><br>

<a href="<%=response.encodeURL("get-session.jsp")%>">Session 依赖于 Cookie，客户端关闭 Cookie 功能时，通过此方法实现 Session</a>
</body>
</html>
