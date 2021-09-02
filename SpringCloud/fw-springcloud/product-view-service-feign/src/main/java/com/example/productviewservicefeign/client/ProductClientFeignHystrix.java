package com.example.productviewservicefeign.client;

import com.example.productviewservicefeign.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ProductClientFeignHystrix
 * @Description: 断路器，当 ProductClientFeign 的接口调用的数据服务不可用时，使用此子类的结果返回
 * @Author: TechRice
 * @Date: 2021/8/29 22:07
 */
@Component
public class ProductClientFeignHystrix implements ProductClientFeign {
    @Override
    public List<Product> productList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(0, "产品数据微服务不可用", 0));

        return productList;
    }
}
