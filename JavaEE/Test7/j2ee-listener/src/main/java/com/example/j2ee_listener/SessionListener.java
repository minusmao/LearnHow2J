package com.example.j2ee_listener;

import javax.servlet.http.*;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    private int onlineTotal;

    public SessionListener() {
    }

    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("监听到 Session 被创建，id 为：" + se.getSession().getId());
        onlineTotal++;
        System.out.println("当前建立的会话数量：" + onlineTotal);
        // 将会话数更新到 application 中
        se.getSession().getServletContext().setAttribute("online_total", onlineTotal);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        System.out.println("监听到 Session 被销毁，id 为：" + se.getSession().getId());
        onlineTotal++;
        System.out.println("当前建立的会话数量：" + onlineTotal);
        // 将会话数更新到 application 中
        se.getSession().getServletContext().setAttribute("online_total", onlineTotal);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
        System.out.println("Session[id: " + sbe.getSession().getId() + "] 添加键值对: [" + sbe.getName() + ": " + sbe.getValue() + "]");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
        System.out.println("Session[id: " + sbe.getSession().getId() + "] 删除键值对: [" + sbe.getName() + ": " + sbe.getValue() + "]");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
        // 注意：sbe.getValue() 得到的是更新前的值
        System.out.println("Session[id: " + sbe.getSession().getId() + "] 更新键值对: [" + sbe.getName() + ": " + sbe.getSession().getAttribute("name") + "]");
    }
}
