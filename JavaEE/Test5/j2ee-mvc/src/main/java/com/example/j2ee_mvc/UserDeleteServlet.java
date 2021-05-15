package com.example.j2ee_mvc;

import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 判读是否登陆 */
        if (request.getSession().getAttribute("login_id") == null) {
            // login_id 为 null 则表示未登录
            response.sendRedirect("login.html");
            return;
        }

        /* 若已登录，执行删除操作 */
        // 获得提交的参数
        int delete_id = Integer.parseInt(request.getParameter("delete_id"));
        // 连接数据库执行删除
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(delete_id);
        // 客户端重定向
        response.sendRedirect("user-list-servlet");
    }
}
