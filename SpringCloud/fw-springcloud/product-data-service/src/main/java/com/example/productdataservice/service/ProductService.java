package com.example.productdataservice.service;

import com.example.productdataservice.pojo.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ProductService
 * @Description: 产品业务逻辑层
 * @Author: TechRice
 * @Date: 2021/8/22 14:55
 */
@Service
public class ProductService {
    @Value("${server.port}")
    private String port;    // 当前服务使用的端口

    /**
     * 返回产品列表
     * @return 产品列表
     */
    public List<Product> listProduct() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1,"product a from port:"+port, 50));
        productList.add(new Product(2,"product a from port:"+port, 100));
        productList.add(new Product(3,"product a from port:"+port, 150));

        return productList;
    }
}
