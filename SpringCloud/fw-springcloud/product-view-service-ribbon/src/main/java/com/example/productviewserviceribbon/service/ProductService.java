package com.example.productviewserviceribbon.service;

import com.example.productviewserviceribbon.client.ProductClientRibbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProductService
 * @Description: 产品业务逻辑层
 * @Author: TechRice
 * @Date: 2021/8/22 16:22
 */
@Service
public class ProductService {
    @Autowired
    private ProductClientRibbon productClientRibbon;    // 注入向数据服务请求数据的 Ribbon 客户端

    /**
     * 调用 Ribbon 客户端请求产品列表
     * @return 产品列表
     */
    public List productList() {
        return productClientRibbon.productList();
    }
}
