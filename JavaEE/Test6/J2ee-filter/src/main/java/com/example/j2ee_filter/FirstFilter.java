package com.example.j2ee_filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Filter一定会随着tomcat的启动自启动
        System.out.println("FirstFilter 已启动");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 查看请求信息
        String ip = request.getRemoteAddr();    // 获取客户端 ip 地址
        String url = ((HttpServletRequest) request).getRequestURL().toString();    // 获取客户端请求的 URL
        // 打印访问信息
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();    // 获取当前时间
        String dateStr = simpleDateFormat.format(date);
        System.out.println(dateStr + " 用户[" + ip + "]访问了: " + url);

        chain.doFilter(request, response);    // 过滤器放行，表示继续运行下一个过滤器，或者最终访问的某个servlet,jsp,html等等
    }
}
