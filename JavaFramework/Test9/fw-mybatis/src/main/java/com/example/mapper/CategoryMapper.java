package com.example.mapper;

import com.example.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/* Mybatis 注解方式 */
public interface CategoryMapper {
    @Select("SELECT * FROM category WHERE id=#{id}")
    public Category get(int i);

    @Select("SELECT * FROM category LIMIT #{begin}, #{length}")
    public List<Category> list(Map<String, Integer> params);
//    public List<Category> list(@Param("begin") int begin, @Param("length") int length);    // 多个参数时，除了传递 Map 还可以使用这种方法

    // 一对多：一个分类Category多个商品Product
    @Select("SELECT * FROM category")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(property = "productList", javaType = List.class, column = "id",
                    many = @Many(select = "com.example.mapper.ProductMapper.listByCategory"))
            // 给 @many 传递多个参数时，写成这个形式：column = "{prop1=col1, prop2=col2}"
    })
    public List<Category> listWithProduct();
}
