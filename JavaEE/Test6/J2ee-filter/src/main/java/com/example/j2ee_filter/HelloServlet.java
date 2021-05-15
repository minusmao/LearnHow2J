package com.example.j2ee_filter;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获得请求的参数，EncodingFilter 已经设置了解码方式，无需再设置
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // 设置响应报文
        response.setContentType("text/html;charset=UTF-8");

        // 输出报文体
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>输入了以下内容</h1>");
        out.println("用户名：" + name + "<br>");
        out.println("密码：" + password + "<br>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}