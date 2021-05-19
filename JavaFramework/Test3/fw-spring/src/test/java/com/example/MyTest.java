package com.example;

import com.example.pojo.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
    @Autowired
    Category category;

    @Test
    public void test1() {
        System.out.println("Test1");
        System.out.println(category.getName());
    }

    @Test
    public void test2() {
        System.out.println("Test2");
        Assert.assertEquals(category.getName(), "category1");    // 期待结果是 category1
    }
}
