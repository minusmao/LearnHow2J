package com.example.mapper;

import com.example.pojo.Order;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/* Mybatis 注解方式 */
public interface OrderMapper {
    @Select("SELECT * FROM order_")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(property = "orderItemList", javaType = List.class, column = "id",
                    many = @Many(select = "com.example.mapper.OrderItemMapper.listByOrderWithProduct"))
    })
    public List<Order> listWith();
}
