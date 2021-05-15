<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/12
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%-- 客户端跳转 --%>
<%--
<% response.sendRedirect("index.jsp"); %>
--%>
<%-- 服务端跳转 --%>
<%--
<% request.getRequestDispatcher("index.jsp").forward(request, response); %>
--%>
<%-- 服务端跳转简化--%>
<jsp:forward page="index.jsp" />
