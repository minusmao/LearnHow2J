package com.example.j2ee_mvc;

import com.example.dao.Sex;
import com.example.dao.User;
import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求的参数
        String name = new String(request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = new String(request.getParameter("password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String sex = request.getParameter("sex");
        String country = new String(request.getParameter("country").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String signature = new String(request.getParameter("signature").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        // 判断是否为空
        if(name == null || password == null) {
            // 输入无效，重新注册
            System.out.println("输入为空");
            response.sendRedirect("register.html");
            return;
        }
        // 判断是否存在该用户
        UserDAO userDAO = new UserDAO();
        User selectUser = userDAO.selectUser(name, password);
        if(selectUser.getId() != -1) {
            // 已存在该用户，重新注册
            System.out.println("用户以存在");
            response.sendRedirect("register.html");
            return;
        }
        // 注册用户
        User user = new User(-1,  name, password, Sex.getSex(sex), country, signature);
        System.out.println("添加：" + user.toString());
        userDAO.addUser(user);
        response.sendRedirect("login.html");
    }
}
