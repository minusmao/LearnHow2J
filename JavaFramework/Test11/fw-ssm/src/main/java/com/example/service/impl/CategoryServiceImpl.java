package com.example.service.impl;

import com.example.mapper.CategoryMapper;
import com.example.pojo.Category;
import com.example.service.CategoryService;
import com.example.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* 表 category 业务实现类 */
@Service
public class CategoryServiceImpl implements CategoryService {
    /* 对象属性 */
    private final CategoryMapper categoryMapper;    // 表 category 的 DAO 层

    /* 构造方法：全参 */
    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /* 对象方法 */
    // 增加
    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    // 增加：连续增加两个，测试事务功能，只要有一个出错，全部不执行
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public void addTwo() {
        // 添加第一个
        Category category1 = new Category();
        category1.setName("name1");
        categoryMapper.add(category1);

        // 添加第二个，名字故意设置很长，数据库放不下
        Category category2 = new Category();
        category2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        categoryMapper.add(category2);
    }

    // 分页查询
    @Override
    public List<Category> list(Page page) { ;
        // 执行 DAO 层
        return categoryMapper.list(page);
    }

    // 查询总数
    @Override
    public int total() {
        return categoryMapper.total();
    }

    // 分页查询，使用 pagehelper 分页插件
    @Override
    public List<Category> listPage() {
        return categoryMapper.listPage();
    }
}
