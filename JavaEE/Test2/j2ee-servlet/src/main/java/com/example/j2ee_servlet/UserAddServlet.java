package com.example.j2ee_servlet;

import com.example.dao.Sex;
import com.example.dao.User;
import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(request.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");
        Sex sex = Sex.getSex(request.getParameter("sex"));
        String country = new String(request.getParameter("country").getBytes("ISO-8859-1"), "UTF-8");
        String signature = new String(request.getParameter("signature").getBytes("ISO-8859-1"), "UTF-8");
        User user = new User(-1, name, password, sex, country, signature);    // 存入数据对象中，id 设为 -1

        // 查询数据库
        UserDAO userDAO = new UserDAO();
        User selectUser = userDAO.selectUser(name, password);
        int selectId = selectUser.getId();
        if(selectId != -1) {
            // 说明存在数据，执行更新
            user.setId(selectId);    // 更新为该 id
            userDAO.updateUser(user);
        } else {
            // 说明不存在数据，执行增加
            userDAO.addUser(user);
        }

        // 跳转到 UserListServlet
        response.sendRedirect("user-list-servlet?begin=0&length=100");
    }
}
