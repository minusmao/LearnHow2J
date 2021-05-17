package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 强制类型转换
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        // 设置解码方式，这样就不用每个 Servlet 单个设置了
        httpRequest.setCharacterEncoding("UTF-8");

        // 获得请求的 URL
        String url = httpRequest.getRequestURL().toString();
        // 判断 URL 是否以 login.html 或 LoginServlet 结尾
        if (url.endsWith("login.html") || url.endsWith("LoginServlet")) {
            // 是，则不拦截，让用户访问登陆页面
            chain.doFilter(request, response);
            return;
        }

        // 获得 Session
        HttpSession session = httpRequest.getSession();
        // 判断是否登陆
        if (session.getAttribute("user") == null) {
            // 为 null 说明未登录，重定向到登陆页面
            httpResponse.sendRedirect("login.html");
        }
        chain.doFilter(request, response);
    }
}
