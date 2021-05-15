package com.example.j2ee_filter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求的参数，EncodingFilter 已经设置了解码方式，无需再设置
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // 设置 Session
        request.getSession().setAttribute("name", name);

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
}
