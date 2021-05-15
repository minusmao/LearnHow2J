<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/13
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // Cookie 对象
  Cookie cookie = new Cookie("name", "galen");    // 键值对
  cookie.setMaxAge(24 * 60 * 60);    // 生命周期，单位：s
  cookie.setPath("set-cookie.jsp");    // 适用范围，只有当访问该路径时提交 Cookie，"/"表示所有路径
  response.addCookie(cookie);    // 表示保存该 Cookie 到客户端
  // 上一步实际的效果是响应报文的首部行有 name=galen; Max-Age=86400; Expires=Fri, 14-May-2021 14:51:50 GMT; Path=set-cookie.jsp 字段
  // 设置 Cookie 后，客户端请求报文的首部行有 Cookie:name=galen 字段
%>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<table width="300" border="1" cellspacing="0">
  <tr>
    <th colspan="2">Cookie</th>
  </tr>
  <%
    Cookie[] cookies = request.getCookies();    // 获取客户端提交的 Cookie
    for (Cookie c : cookies) {
      out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
    }
    /* 除了自己设置的 Cookie，还有 Tomcat 和 IDEA 设置的 Cookie，分别是：JSESSIONID	、Idea-4ac718c7 */
    /* JSESSIONID 是 Tomcat 用于实现 Session 功能的 Cookie */
  %>
</table>
</body>
</html>
