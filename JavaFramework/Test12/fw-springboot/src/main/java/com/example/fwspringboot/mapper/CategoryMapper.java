package com.example.fwspringboot.mapper;

import com.example.fwspringboot.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 注解 @Mapper 表示这是一个Mybatis Mapper接口
@Mapper
public interface CategoryMapper {
    // 增加
    @Insert("INSERT INTO category (name) VALUES (#{name})")
    public int save(Category category);

    // 删除
    @Delete("DELETE FROM category WHERE id = #{id}")
    public void delete(int id);

    // 更新
    @Update("UPDATE category SET name = #{name} WHERE id = #{id}")
    public void update(Category category);

    // 查询
    public Category findById(@Param("id") int id);

    // 查询所有，可以通过 PageHelper 查询部分
    @Select("SELECT * FROM category")
    public List<Category> listAll();

    @Select("SELECT * FROM category LIMIT #{begin}, #{length}")
    public List<Category> list(@Param("begin") int begin, @Param("length") int length);
}
