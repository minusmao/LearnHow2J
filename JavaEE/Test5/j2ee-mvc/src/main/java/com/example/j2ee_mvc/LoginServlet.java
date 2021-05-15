package com.example.j2ee_mvc;

import com.example.dao.User;
import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 客户端跳转
        response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求参数
        String name = new String(request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = new String(request.getParameter("password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        // 查询数据库
        UserDAO userDAO = new UserDAO();
        User selectUser = userDAO.selectUser(name, password);
        // 判断是否存在该 name 和 password
        if (selectUser.getId() == -1) {
            // 账户密码错误，重新登陆
            response.sendRedirect("login.html");
        } else {
            // 成功登陆，将 id 信息存入 Session 中
            request.getSession().setAttribute("login_id", selectUser.getId());    // 不能写成 login-id，因为 EL 表达式会认为有减号
            // 转跳到 UserListServlet
            response.sendRedirect("user-list-servlet");
        }
    }
}
