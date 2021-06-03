package com.example.fwspringboot;

import com.example.fwspringboot.mapper.CategoryMapper;
import com.example.fwspringboot.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FwSpringbootApplicationTests {
    // 注入 CategoryMapper
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
        List<Category> categoryList = categoryMapper.list(0, 5);
        for (Category c : categoryList) {
            System.out.println(c.toString());
        }
    }

}
