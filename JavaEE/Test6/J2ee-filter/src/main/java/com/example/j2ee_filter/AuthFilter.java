package com.example.j2ee_filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/* 登陆验证拦截器 */
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 强制类型转换
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        // 查看是否访问登陆界面
        String requestUrlStr = httpRequest.getRequestURL().toString();
        if(requestUrlStr.endsWith("login.html") || requestUrlStr.endsWith("LoginServlet")) {
            // 是，则不拦截
            chain.doFilter(request, response);
            return;
        }

        // 查看 Session
        HttpSession session = httpRequest.getSession();
        // 判断是否登陆
        if(session.getAttribute("name") == null) {
            // 为 null 说明未登录
            httpResponse.sendRedirect("login.html");
        }

        chain.doFilter(request, response);
    }
}
