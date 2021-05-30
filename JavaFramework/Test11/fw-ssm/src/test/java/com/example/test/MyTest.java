package com.example.test;

import com.example.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
    @Autowired
    private CategoryService categoryService;    // 由 Spring 注入

    // 测试事务功能，增加两条数据
    @Test
    public void testAddTwo() {
        categoryService.addTwo();
    }
}
