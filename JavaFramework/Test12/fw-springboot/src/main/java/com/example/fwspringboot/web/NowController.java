package com.example.fwspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

@Controller
@RequestMapping("now")
public class NowController {
    @RequestMapping("now")
    public String now(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));

        // 这时返回"hello"就不再是字符串，而是根据application.properties 中的视图重定向，到/WEB-INF/jsp目录下去寻找hello.jsp文件
        // 如果注解是 @RestController 则返回字符串
        return "now";
    }

    @RequestMapping("error")
    public String error() throws Exception {
        if(true) {
            throw new Exception("some exception");
        }

        return "now";
    }
}
