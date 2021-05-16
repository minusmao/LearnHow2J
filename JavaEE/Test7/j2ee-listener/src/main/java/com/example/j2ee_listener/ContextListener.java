package com.example.j2ee_listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebListener
public class ContextListener implements ServletContextListener {

    public ContextListener() {
        System.out.println("ContextListener 启动");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("Web 应用初始化成功");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("Web 应用被销毁");
    }
}
