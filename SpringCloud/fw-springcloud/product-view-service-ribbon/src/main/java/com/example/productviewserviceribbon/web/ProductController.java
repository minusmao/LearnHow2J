package com.example.productviewserviceribbon.web;

import com.example.productviewserviceribbon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: ProductController
 * @Description: 产品控制层
 * @Author: TechRice
 * @Date: 2021/8/22 16:26
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("ps", productService.productList());

        return "products";
    }
}
