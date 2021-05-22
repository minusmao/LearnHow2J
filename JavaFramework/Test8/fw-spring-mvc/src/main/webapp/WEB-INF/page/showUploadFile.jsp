<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Base64" %>
<%--
  Created by IntelliJ IDEA.
  User: 26307
  Date: 2021/5/22
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 保存的文件
    File imageFile = new File("F:/images", (String) request.getAttribute("imageName"));
    int size = (int) imageFile.length();    // 文件大小
    // 获取二进制数据
    InputStream in = new FileInputStream(imageFile);
    byte[] bytes = new byte[size];
    in.read(bytes, 0, size);
    // 进行 base64 编码，使用参考：https://www.runoob.com/java/java8-base64.html
    String base64image = Base64.getEncoder().encodeToString(bytes);
%>
<html>
<head>
    <title>展示上传的图片</title>
</head>
<body>
<img src="data:image/png;base64,<%=base64image%>" alt="图片加载失败">
</body>
</html>
