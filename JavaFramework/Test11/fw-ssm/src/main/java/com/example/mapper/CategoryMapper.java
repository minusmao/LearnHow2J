package com.example.mapper;

import com.example.pojo.Category;
import com.example.util.Page;

import java.util.List;

/* DAO: 操作 category 表 */
public interface CategoryMapper {
    /* CRUD */
    public int add(Category category);       // 增加：指定 Category 对象
    public void delete(int id);              // 删除：指定 id
    public int update(Category category);    // 更改：指定 Category 对象
    public Category get(int id);             // 查询：指定 id

    /* 特殊查询 */
    public List<Category> list(Page page);    // 分页查询
    public int total();                       // 查询总数
    public List<Category> listPage();         // 分页查询，使用 pagehelper 分页插件

    /* 联结查询 */
}
