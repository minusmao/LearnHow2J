package com.example.configserver;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer       // 表示是个配置服务器
@EnableDiscoveryClient    // 表示用于发现 Eureka 注册中心的微服务
@EnableEurekaClient       // 表示这是个 EurekaClient
public class ConfigServerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ConfigServerApplication.class, args);
        // 启动时设置端口号
        int port = 8030;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ConfigServerApplication.class).properties("server.port=" + port).run(args);
    }

}
