package com.example.zuul;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy          // 开启 Zuul 网关
@EnableEurekaClient       // 表示这是个 EurekaClient
@EnableDiscoveryClient    // 表示用于发现 Eureka 注册中心的微服务
public class ZuulApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ZuulApplication.class, args);
        // 启动时设置端口号
        int port = 8060;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ZuulApplication.class).properties("server.port=" + port).run(args);
    }

}
