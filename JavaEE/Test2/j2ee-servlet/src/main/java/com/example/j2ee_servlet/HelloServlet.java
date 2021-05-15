package com.example.j2ee_servlet;

import java.io.*;
import java.util.Arrays;
import javax.servlet.ServletConfig;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// 使用 web.xml 的配置方式
// @WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    // Servlet 为单例模型，生命周期由【实例化(构造方法)、初始化(init方法)、提供服务(service方法)、销毁(destroy方法)、被回收】几个步骤组成
    // 实例化(构造方法)会在客户端第一次访问时调用，可以设置成 Tomcat 启动时调用，方便提前做一些初始化工作（校验数据库）
    // 配置方式：在 web.xml 中对应的 Servlet 里加一句 <load-on-startup>10</load-on-startup>，中间数字在 1~99 之间，，数字越小，启动的优先级越高

    // 初始化 init 在构造方法执行后执行
    public void init(ServletConfig config) {
        System.out.println(config.getServletName() + "初始化成功");
    }

    // 调用 doGet() 或者 doPost() 之前，会调用 service() 方法判断 GET 和 POST，也可以重写 service() 方法，自行处理
//    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {}

    // 处理 GET 请求报文
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取请求报文提交的参数
        String name = request.getParameter("name");    // get方式，能直接解码成UTF-8
        String password = request.getParameter("password");

        // 设置响应报文信息
        response.setContentType("text/html;charset=UTF-8");

        // 获得输出流，输出信息
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>用户信息如下</h1>");
        out.println("<span>姓名：" + name + "</span><br>");
        out.println("<span>密码：" + password + "</span><br>");
        out.println("</body></html>");
    }

    // 处理 POST 请求报文
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取请求报文提交的参数
        request.setCharacterEncoding("UTF-8");    // 设置按 UTF-8 解码（默认按 ISO-8859-1）
        String name = request.getParameter("name");

        System.out.println("测试编码是否正确：" + name);    // 若没设置解码方式，会出现乱码，浏览器发过来是 UTF-8 编码的“字节数组”，默认按 ISO-8859-1 编码
        // 也可以通过如下方式解码
//        byte[] bytes = name.getBytes("ISO-8859-1");    // 按 ISO-8859-1 解码得到字节数组
//        String nameUTF = new String(bytes, "UTF-8");    // 将字节数组重新按 UTF-8 编码
//        System.out.println("测试编码是否正确：" + nameUTF);

        String password = request.getParameter("password");
        String age = request.getParameter("age");
//        String hobby = request.getParameter("hobby");    // 此方式只能获取复选框一个值
        String[] bobbies = request.getParameterValues("hobby");    // 此方式可以获取所有值
        String hobby = Arrays.toString(bobbies);
        String country = request.getParameter("country");

        // 设置响应报文头信息
        response.setContentType("text/html;charset=UTF-8");

        // 设置响应报文体信息
        String html = "<html><head>" +
                "<title>Hello Servlet</title></head>" +
                "<body><h1>用户基本信息如下：</h1>" +
                "姓名：%s<br>" +
                "密码：%s<br>" +
                "性别：%s<br>" +
                "爱好：%s<br>" +
                "国籍：%s<br>" +
                "</body></html>";
//        String message = String.format(html, nameUTF, password, age, hobby, country);
        String message = String.format(html, name, password, age, hobby, country);

        // 获取输出流，输出信息
        PrintWriter out = response.getWriter();
        out.println(message);
    }

    // Web 容器关闭时，会销毁 Servlet 并调用其 destroy() 方法
    // 重启时，可能调用可能不调用，具体自行配置 Tomcat 的 server.xml
    // <Context path="/" docBase="e:/project/j2ee/web" debug="0" reloadable="false" /> 更改 reloadable 的值
    public void destroy() {
    }
}