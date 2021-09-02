package com.example.hystrixdashboard;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;

/**
 * @ClassName: AccessViewServiceUtil
 * @Description: 通过此工具类，不停地访问视图服务，观察断路器监控
 * @Author: TechRice
 * @Date: 2021/9/2 20:40
 */
public class AccessViewServiceUtil {
    public static void main(String[] args) {
        // 循环访问视图服务
        for (int i = 0; i < 60; i++) {
            // 访问
            String html = HttpUtil.get("http://127.0.0.1:8020/products");
            System.out.println("html length:" + html.length());
            // 延时
            ThreadUtil.sleep(1000);
        }
    }
}
