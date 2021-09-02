package com.example.productviewserviceribbon.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: ProductClientRibbon
 * @Description: Ribbon 客户端，使用 RestTemplate 进行调用，从数据服务中获取数据
 * @Author: TechRice
 * @Date: 2021/8/22 16:10
 */
@Component
public class ProductClientRibbon {
    @Resource
    private RestTemplate restTemplate;

    /**
     * 请求 PRODUCT-DATA-SERVICE 服务的产品列表
     * @return 返回产品列表
     */
    public List productList() {
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products", List.class);
    }
}
