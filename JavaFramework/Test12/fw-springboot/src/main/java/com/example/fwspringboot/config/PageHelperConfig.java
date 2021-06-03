package com.example.fwspringboot.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

// 注解 @Configuration 表示 PageHelperConfig 这个类是用来做配置的
@Configuration
public class PageHelperConfig {
    // 注解 @Bean 表示启动 PageHelper 这个拦截器
    @Bean
    public PageHelper pageHelper() {
        // 创建 PageHelper 对象
        PageHelper pageHelper = new PageHelper();

        // 创建 Properties 配置对象
        Properties properties = new Properties();
        // offsetAsPageNum: 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
        properties.setProperty("offsetAsPageNum", "true");
        // rowBoundsWithCount: 设置为true时，使用RowBounds分页会进行count查询
        properties.setProperty("rowBoundsWithCount", "true");
        // reasonable: 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
        properties.setProperty("reasonable", "true");

        // 设置配置对象
        pageHelper.setProperties(properties);

        return pageHelper;
    }
}
