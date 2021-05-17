package com.example.j2ee_shop;

import com.example.dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubmitServlet", value = "/SubmitServlet")
public class SubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得 HttpSession
        HttpSession session = request.getSession();

        // 获得当前用户
        User user = (User) session.getAttribute("user");

        // 获得 session 里的 order_item_list
        List<OrderItem> orderItemList = (List<OrderItem>) session.getAttribute("order_item_list");

        // 判断是否为空
        if (orderItemList.isEmpty()) {
            // 如果为空则跳回商品列表
            response.sendRedirect("ProductListServlet");
            return;
        }

        // 数据库（order_）：创建订单
        OrderDAO orderDAO = new OrderDAO();
        Order order = orderDAO.insertOrder(user.getId());    // 传入 user_id

        // 数据库（order_item）：创建订单项
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        // 将所有订单项添加到数据库中，订单 id 为新建的订单 order.getId()
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderId(order.getId());    // 设置订单 id
            orderItemDAO.insertOrderItem(orderItem);    // 操作数据库
        }
        // 客户端跳转
        response.sendRedirect("OrderItemListServlet?order_id=" + order.getId());
    }
}
