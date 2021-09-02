package com.example.productviewservicefeign;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

/**
 * @ClassName: FreshConfigUtil
 * @Description: 更新配置的工具类，运行后调用视图服务的 /actuator/bus-refresh 接口，会从仓库中更新配置
 * @Author: TechRice
 * @Date: 2021/8/31 23:30
 */
public class FreshConfigUtil {
    public static void main(String[] args) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        System.out.println("从 git 仓库获取，请耐心等待...");
        String result = HttpUtil.createPost("http://localhost:8020/actuator/bus-refresh").addHeaders(headers).execute().body();
        System.out.println("result: "+result);
        System.out.println("refresh 完成！");
    }
}
