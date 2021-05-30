package com.example.service;

import com.example.pojo.Category;
import com.example.util.Page;

import java.util.List;

/* 表 category 业务层接口 */
public interface CategoryService {
    /* 抽象方法 */
    // 增加
    public void add(Category category);
    // 增加：连续增加两个，测试事务功能
    public void addTwo();
    // 分页查询
    public List<Category> list(Page page);
    // 查询总数
    public int total();
    // 分页查询，使用 pagehelper 分页插件
    public List<Category> listPage();
}
