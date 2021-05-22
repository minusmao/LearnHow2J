package com.example.controller;

import com.example.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {
    @RequestMapping("/addProduct")
    public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse response) {
        // 视图对象
        return new ModelAndView("addProduct");
    }

    @RequestMapping("/showProduct")
    public ModelAndView showProduct(Product product) {
        /*
            addProduct.jsp 提交的name和price会自动注入到参数 product里
            参数product会默认被当做值加入到 ModelAndView 中（为 requestScope 范围）
        */
        // 给 product 设置 id
        product.setId(10);
        // 视图对象
        return new ModelAndView("showProduct");
    }
}
