package com.example.j2ee_servlet;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

//@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 请求对象 request 常用方法（HTTP 请求报文包括：请求行、首部行、空行、实际主体）
        /* 基本信息：TCP 报头信息、HTTP 请求行信息 */
        String[] baseInfos = new String[10];
        baseInfos[0] = "getRequestURL() 获得请求的 URL 信息：" + request.getRequestURL();
        baseInfos[1] = "getRequestURI() 获得请求的 URI 信息：" + request.getRequestURI();
        baseInfos[2] = "getQueryString() 获得请求的 URL 的参数部分：" + request.getQueryString();
        baseInfos[3] = "getRemoteAddr() 获得客户端 IP 地址：" + request.getRemoteAddr();
        baseInfos[4] = "getRemotePort() 获得客户端端口：" + request.getRemotePort();
        baseInfos[5] = "getRemoteHost() 获得客户端主机名：" + request.getRemoteHost();
        baseInfos[6] = "getRemoteUser() 获得客户端用户名：" + request.getRemoteUser();
        baseInfos[7] = "getLocalAddr() 获得服务端 IP 地址：" + request.getLocalAddr();
        baseInfos[8] = "getLocalName() 获得服务端主机名：" + request.getLocalName();
        baseInfos[9] = "getMethod() 获得请求方式：" + request.getMethod();

        /* 首部行信息：首部行由多行首部字段组成 */
        Enumeration<String> enumeration = request.getHeaderNames();             // 获取所有字段名
        ArrayList<String> headInfoList = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            String headName = enumeration.nextElement();                        // 读取一个字段名
            headInfoList.add(headName + ": " + request.getHeader(headName));    // 获取该字段名的值
        }

        /* 获取请求参数：无论客户端是 GET 还是 POST 方式 */
        // request.getParameter("参数名"): 用于获取单值的参数
        // request.getParameterValues("参数名"): 用于获取具有多值的参数，比如多选框
        // request.getParameterMap(): 用于遍历所有的参数，并返回Map类型
        Map<String, String[]> paramInfoMap = request.getParameterMap();    // 获得请求参数的 Map 格式
        Set<String> paramNameSet = paramInfoMap.keySet();                  // 获得 Map 的所有 Key
        // 遍历出所有数据
        ArrayList<String> paramInfoList = new ArrayList<>();
        for (String paramName : paramNameSet) {
            String paramValue = Arrays.toString(paramInfoMap.get(paramName));    // 获得 Key 对应的 Value

            // 中文问题，需重新解码
            byte[] bytes = paramValue.getBytes(StandardCharsets.ISO_8859_1);
            String paramValueUTF = new String(bytes, StandardCharsets.UTF_8);

            paramInfoList.add(paramName + ": " + paramValueUTF);
        }

        // 相应对象 response 常用方法（HTTP 响应报文包括：状态行、首部行、空行、实际主体）
        /* 设置响应格式、响应编码；作用于首部行 */
        response.setContentType("text/html;charset=UTF-8");    // 同时设置了响应格式、编码，并通知了浏览器以 UTF-8 解码
        response.setCharacterEncoding("UTF-8");    // 只设置了响应报文的编码，报文的首部行没有编码信息，浏览器使用自身默认解码方式

        /* 设置客户端跳转：作用于状态行，状态码：301永久跳转、302临时跳转 */
        // 301永久跳转
//        response.setStatus(301);
//        response.setHeader("Location", "fail.html");
        // 302临时跳转
//        response.sendRedirect("fail.html");

        /* 设置不使用缓存：作用于首部行 */
//        response.setDateHeader("Expires",0 );
//        response.setHeader("Cache-Control","no-cache");
//        response.setHeader("pragma","no-cache");

        /* 输出报文体：作用于实际主体 */
        PrintWriter out = response.getWriter();    // 获取输出流
        out.println("<html><body><h4>请求 request 获得基本信息</h4>");
        for (String outStr : baseInfos) {
            out.println(outStr + "<br>");
        }
        out.println("<h4>请求 request 获得首部行信息：</h4>");
        for (String outStr : headInfoList) {
            out.println(outStr + "<br>");
        }
        out.println("<h4>请求 request 获得请求参数</h4>");
        for (String outStr : paramInfoList) {
            out.println(outStr + "<br>");
        }
        out.println("</body></html>");
    }
}
