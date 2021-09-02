package com.example.productdataservice.controller;

import com.example.productdataservice.pojo.Product;
import com.example.productdataservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: ProductController
 * @Description: 产品控制层
 * @Author: TechRice
 * @Date: 2021/8/22 15:03
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> productList() {
        return productService.listProduct();
    }
}
