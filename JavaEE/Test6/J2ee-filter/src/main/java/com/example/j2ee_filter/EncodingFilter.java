package com.example.j2ee_filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 强制类型转化
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 设置解码方式，这一次请求后面的 Servlet 无需再设置解码方式
        httpRequest.setCharacterEncoding("UTF-8");
        System.out.println("EncodingFilter 成功设置解码方式为 UTF-8");

        chain.doFilter(request, response);
    }
}
