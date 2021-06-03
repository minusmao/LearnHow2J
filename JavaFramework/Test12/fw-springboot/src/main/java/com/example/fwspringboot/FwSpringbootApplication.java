package com.example.fwspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/* jar 方式 */
/*
// 注解 @SpringBootApplication 表示这是一个 SpringBoot 应用
@SpringBootApplication
public class FwSpringbootApplication {

    public static void main(String[] args) {
        // 启动 tomcat 默认端口是 8080
        SpringApplication.run(FwSpringbootApplication.class, args);
    }

}
*/

/* war 方式 */
@SpringBootApplication
@ServletComponentScan
public class FwSpringbootApplication extends SpringBootServletInitializer {
    /* 对象方法 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FwSpringbootApplication.class);
    }

    /* 程序入口 */
    public static void main(String[] args) {
        SpringApplication.run(FwSpringbootApplication.class, args);
    }
}
