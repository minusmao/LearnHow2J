package com.example.fwspringboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 是 spring4 里的新注解，是 @ResponseBody 和 @Controller 的缩写
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "Hello Spring Boot";
    }
}
