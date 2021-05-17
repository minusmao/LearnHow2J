package com.example.j2ee_shop;

import com.example.dao.OrderItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 购物车 */
@WebServlet(name = "ShoppingCarServlet", value = "/ShoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求的参数
        int productId = Integer.parseInt(request.getParameter("product_id"));    // 产品 id
        int number = Integer.parseInt(request.getParameter("number"));           // 产品数量

        // 获得 HttpSession
        HttpSession session = request.getSession();

        // 获得 Session 中的 order_item_list
        List<OrderItem> orderItemList = (List<OrderItem>) session.getAttribute("order_item_list");
        if(orderItemList == null) {
            // 不存在则创建
            orderItemList = new ArrayList<>();
            session.setAttribute("order_item_list", orderItemList);    // 存入 Session
        }

        // 创建 OrderItem 对象
        OrderItem orderItem = new OrderItem(-1, productId, -1, number);    // 暂时还没下订单，所以 id 和 orderId 还没有

        // 判断 orderItemList 中是否存在该 productId
        boolean found = false;
        for (OrderItem oi : orderItemList) {
            if (orderItem.getProductId() == oi.getProductId()) {
                // 存在则只增加数量
                oi.setNumber(oi.getNumber() + orderItem.getNumber());
                found = true;
            }
        }
        // 如果不存在则增加到 orderItemList 中
        if (found == false) {
            orderItemList.add(orderItem);
        }

        // 服务端跳转
        request.getRequestDispatcher("WEB-INF/shopping-car.jsp").forward(request, response);
    }
}
