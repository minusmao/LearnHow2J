package com.example.j2ee_servlet;

import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        int id = Integer.parseInt(request.getParameter("id"));

        // 操作数据库
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(id);

        // 跳转到 UserListServlet
        response.sendRedirect("user-list-servlet?begin=0&length=100");
    }
}
