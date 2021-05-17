package com.example.j2ee_shop;

import com.example.dao.Product;
import com.example.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询数据库的 product 表
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.selectProductList(0, 100);

        // 将数据存入 requestScope
        request.setAttribute("product_list", productList);

        // 服务端跳转
        request.getRequestDispatcher("WEB-INF/product-list.jsp").forward(request, response);
    }
}
