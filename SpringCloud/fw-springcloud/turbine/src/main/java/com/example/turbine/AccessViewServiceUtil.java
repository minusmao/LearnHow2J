package com.example.turbine;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;

/**
 * @ClassName: AccessViewServiceUtil
 * @Description: 通过此工具类，不停地访问多个视图服务（多个端口），观察断路器监控
 * @Author: 26307
 * @Date: 2021/9/2 21:43
 */
public class AccessViewServiceUtil {
    public static void main(String[] args) {
        // 循环访问视图服务
        for (int i = 0; i < 60; i++) {
            // 访问
            access(8020);
            access(8021);
            // 延时
            ThreadUtil.sleep(1000);
        }
    }

    /**
     * 给指定端口发起请求
     * @param port 端口
     */
    public static void access(int port) {
        // 访问
        String html = HttpUtil.get("http://127.0.0.1:" +port + "/products");
        System.out.println("html length:" + html.length());
    }
}
