package com.example.productviewservicefeign.client;

import com.example.productviewservicefeign.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName: ProductClientFeign
 * @Description: Feign 客户端，从数据服务中获取数据，封装了 Ribbon 调用 RestTemplate 的方式
 * @Author: 26307
 * @Date: 2021/8/24 20:56
 */
@FeignClient(value = "PRODUCT-DATA-SERVICE",
        configuration= FeignClientsConfiguration.class,
        fallback = ProductClientFeignHystrix.class)
public interface ProductClientFeign {
    /**
     * 请求 PRODUCT-DATA-SERVICE 服务的产品列表
     * @return 返回产品列表
     */
    @GetMapping("/products")
    List<Product> productList();
}
