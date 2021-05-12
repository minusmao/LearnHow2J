package com.example.j2ee_servlet;

import com.example.dao.User;
import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// 使用 web.xml 的配置方式
// @WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求报文提交的数据
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // 查询数据库
        UserDAO userDAO = new UserDAO();                   // 数据访问对象
        User user = userDAO.selectUser(name, password);    // 查询数据，返回数据对象
        System.out.println(user.getId());

        // 判断并跳转（跳转方式分两种：服务端跳转、客户端跳转）
        if(user.getId() != -1) {
            // 信息错误，使用服务端跳转，客户端无法察觉
            request.getRequestDispatcher("login-success.html").forward(request, response);
        } else {
            // 信息错误，使用客户端跳转，让客户端重新发请求
            response.sendRedirect("login-fail.html");    // 响应客户端，告诉客户端接下来请求 login-fail.html
        }
    }

}
