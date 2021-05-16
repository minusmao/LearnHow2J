package com.example.j2ee_listener;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 全局范围添加键值对
        ServletContext application = request.getServletContext();
        application.setAttribute("name1", "galen1");
        application.setAttribute("name2", "galen2");
        application.removeAttribute("name1");    // 删除一个

        // 设置响应报文
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}