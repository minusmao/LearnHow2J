package com.example.mapper;

import com.example.pojo.OrderItem;
import com.example.pojo.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/* Mybatis 注解方式 */
public interface OrderItemMapper {
    @Select("SELECT * FROM order_item WHERE order_id=#{orderId}")
    @Results({
            @Result(property = "product", javaType = Product.class, column = "product_id",
                    one = @One(select = "com.example.mapper.ProductMapper.get"))
    })
    public List<OrderItem> listByOrderWithProduct(int orderId);
}
