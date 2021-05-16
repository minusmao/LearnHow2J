package com.example.j2ee_listener;

import javax.servlet.*;

public class RequestListener implements ServletRequestListener {

    public RequestListener() {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("产生一个请求：" + sre.getServletRequest().toString());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("销毁一个请求：" + sre.getServletRequest().toString());
    }
}
