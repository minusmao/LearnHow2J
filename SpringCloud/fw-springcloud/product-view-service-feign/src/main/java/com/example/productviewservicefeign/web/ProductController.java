package com.example.productviewservicefeign.web;

import com.example.productviewservicefeign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: ProductController
 * @Description: 产品控制层
 * @Author: TechRice
 * @Date: 2021/8/24 21:10
 */
@Controller
@RefreshScope    // 实现配置、实例热加载
public class ProductController {
    @Autowired
    private ProductService productService;

    @Value("${version}")
    private String version;    // 注入配置信息

    @GetMapping("/products")
    public String productList(Model model) {
        model.addAttribute("version", version);
        model.addAttribute("ps", productService.productList());

        return "products";
    }
}
