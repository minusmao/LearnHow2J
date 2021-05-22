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
<a href="hello-servlet">Hello Servlet</a><br>
<p>${message}</p><br>
<a href="addProduct">Add Product</a><br>
<a href="check">check</a><br>
<a href="clear">clear</a><br>
<img src="img.png" alt="加载失败"/>
<h4>图片上传</h4>
<form action="uploadImage" method="post" enctype="multipart/form-data">
    <input type="file" name="image" accept="image/png" placeholder="请选择图片">
    <input type="submit">
</form>
<h4>拦截器添加的内容</h4>
<p>${date}</p>
</body>
</html>