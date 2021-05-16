package com.example.j2ee_listener;

import javax.servlet.*;
import javax.servlet.http.*;

public class ContextAttributeListener implements ServletContextAttributeListener {

    public ContextAttributeListener() {
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeAdded(event);

        System.out.println("ServletContext 增加的内容为：" + event.getName() + ": " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeRemoved(event);

        System.out.println("ServletContext 删除的内容为：" + event.getName() + ": " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeReplaced(event);

        System.out.println("ServletContext 更新的内容为：" + event.getName() + ": " + event.getValue());
    }
}
