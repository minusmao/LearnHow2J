package com.example.j2ee_shop;

import com.example.dao.OrderItem;
import com.example.dao.OrderItemDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderItemServlet", value = "/OrderItemListServlet")
public class OrderItemListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求的参数
        int orderId = Integer.parseInt(request.getParameter("order_id"));    // 获得订单 id

        // 查询数据库
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        List<OrderItem> orderItemList = orderItemDAO.selectOrderItemList(orderId);

        // 存入 requestScope 中
        request.setAttribute("order_item_list", orderItemList);
        request.setAttribute("order_id", orderId);

        // 服务端重定向
        request.getRequestDispatcher("WEB-INF/order-item-list.jsp").forward(request, response);
    }
}
