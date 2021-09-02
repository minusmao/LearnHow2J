package com.example.productviewservicefeign.service;

import com.example.productviewservicefeign.client.ProductClientFeign;
import com.example.productviewservicefeign.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProductService
 * @Description: 产品业务逻辑层
 * @Author: TechRice
 * @Date: 2021/8/24 21:04
 */
@Service
public class ProductService {
    @Autowired
    private ProductClientFeign productClientFeign;        // 注入向数据服务请求数据的 Feign 客户端

    /**
     * 调用 Feign 客户端请求产品列表
     * @return 产品列表
     */
    public List<Product> productList() {
        return productClientFeign.productList();
    }
}
