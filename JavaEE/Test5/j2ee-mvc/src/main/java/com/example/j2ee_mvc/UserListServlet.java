package com.example.j2ee_mvc;

import com.example.dao.User;
import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 先判断是否登陆 */
        // 获得 Session 并判断 login-id
        HttpSession session = request.getSession();
        if (session.getAttribute("login_id") == null) {
            // login-id 若为 null，说明未登陆，请登陆
            response.sendRedirect("login.html");    // 客户端重定向到登陆页面 login.html
            return;
        }

        /* 若已登录，则查询并展示数据 */
        // 分页遍历
        int begin;         // 数据开始位置
        int length = 5;    // 数据量
        // 获得传参
        try {
            begin = Integer.parseInt(request.getParameter("begin"));    // 获取客户端需要的开始位置
        } catch (NumberFormatException e) {
            // 当浏览器没有传参数时
            begin = 0;
        }
        // 操作数据库
        UserDAO userDAO = new UserDAO();
        int total = userDAO.getTotal();
        List<User> userList = userDAO.selectAllUsers(begin, length);    // 按指定位置和数量遍历 user
        // 存入数据
        request.setAttribute("userList", userList);
        request.setAttribute("pre", begin-length>=0 ? begin-length : 0);     // 传入上一页开始的位置
        request.setAttribute("next", begin+length<=total? begin+length : 0);    // 传入下一页的开始位置
        // 服务端跳转
        request.getRequestDispatcher("WEB-INF/user-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
