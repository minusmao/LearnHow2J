<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">hello-servlet</a><br>
<form method="post" action="hello-servlet">
    <input type="text" name="name" placeholder="Please input your name"><br>
    <input type="password" name="password" placeholder="Please input your password"><br>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>