package com.example.fw_spring;

import com.example.pojo.Category;
import com.example.pojo.Product;
import com.example.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // 得到 spring 的 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});

        // 通过 spring 得到对象
        Category category = (Category) context.getBean("category");
        Product product = (Product) context.getBean("product");
        System.out.println(product.getCategory() == category);    // 返回 true ，说明是同一个 Category 对象

        // 测试 AOP
        ProductService productService = (ProductService) context.getBean("productService");
        productService.doService();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>ID: " + category.getId() + ", Name: " + category.getName() + "</p>");
        out.println("<p>ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice() + "</p>");
        out.println("<p>ID: " + product.getCategory().getId() + ", Name: " + product.getCategory().getName() + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}