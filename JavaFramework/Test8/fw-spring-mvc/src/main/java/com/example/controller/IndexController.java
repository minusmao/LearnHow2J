package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/* 用 XML 方式 */
//public class IndexController implements Controller {
//    @Override
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("message", "Hello Spring MVC");
//        return mav;
//    }
//}

/* 用注解方式 */
@Controller
public class IndexController {
    @RequestMapping({"/", "/index"})
    public ModelAndView handleRequest() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

    // 实现客户端跳转
    @RequestMapping("/jump")
    public ModelAndView jump() {
        // 视图对象
        return new ModelAndView("redirect:/index");
    }

    // 操作 session
    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        /*
            session 会默认被加入到 ModelAndView 中
        */
        // 操作 session
        Integer count = (Integer) session.getAttribute("count");    // 取出 count
        if (count == null) {
            count = Integer.valueOf(0);
        }
        count++;
        session.setAttribute("count", count);    // 更新 count

        // 视图对象
        return new ModelAndView("check");
    }

    // 练习：清空 session 中的 count
    @RequestMapping("/clear")
    public ModelAndView clear(HttpSession session) {
        // 操作 session
        session.removeAttribute("count");
        // 视图跳转
        return new ModelAndView("redirect:check");
    }
}
