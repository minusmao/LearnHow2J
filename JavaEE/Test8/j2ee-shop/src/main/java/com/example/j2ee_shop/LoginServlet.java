package com.example.j2ee_shop;

import com.example.dao.User;
import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求的参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // 查询数据库
        UserDAO userDAO = new UserDAO();
        User user = userDAO.selectUser(name, password);    // 若不存在，则 id 为 -1
        // 判断是否存在该用户
        if (user.getId() == -1) {
            // id 为 -1 则登陆失败
            response.sendRedirect("login.html");
        } else {
            // id 不为 1 则登陆成功，将用户信息存入 Session 中
            HttpSession session = request.getSession();    // 获得 Session
            session.setAttribute("user", user);         // 存入登陆的 user
            // 重定向到商品列表
            response.sendRedirect("ProductListServlet");
        }
    }
}
