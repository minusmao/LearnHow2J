package com.example.j2ee_shop;

import com.example.dao.Order;
import com.example.dao.OrderDAO;
import com.example.dao.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderListServlet", value = "/OrderListServlet")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前登陆的用户
        User user = (User) request.getSession().getAttribute("user");

        // 查询数据库
        OrderDAO orderDAO = new OrderDAO();
        List<Order> orderList = orderDAO.selectOrderList(user.getId());

        // 将数据存入 requestScope 中
        request.setAttribute("order_list", orderList);

        // 服务端跳转
        request.getRequestDispatcher("WEB-INF/order-list.jsp").forward(request, response);
    }
}
