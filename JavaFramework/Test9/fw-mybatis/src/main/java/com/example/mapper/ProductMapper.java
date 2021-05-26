package com.example.mapper;

import com.example.pojo.Category;
import com.example.pojo.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/* Mybatis 注解方式 */
public interface ProductMapper {
    @Select("SELECT * FROM product WHERE category_id=#{category_id}")
    @Results(id="ProductBean", value = {
            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "name", property = "name"),     // 不注解，依然可以取出，只要数据库中的字段名和对象的属性名一样即可
            @Result(column = "price", property = "price")
    })
    public List<Product> listByCategory(int categoryId);

    @Select("SELECT * FROM product")
    @Results({
            @Result(property = "category", javaType = Category.class, column = "category_id",
                    one = @One(select = "com.example.mapper.CategoryMapper.get"))
    })
    public List<Product> listWithCategory();

    @Select("SELECT * FROM product WHERE id=#{id}")
    public Product get(int id);
}
