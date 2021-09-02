package com.example.hystrixdashboard;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard    // 启动断路器监控
public class HystrixDashboardApplication {

    public static void main(String[] args) {
//        SpringApplication.run(HystrixDashboardApplication.class, args);
        // 启动时设置端口号
        int port = 8040;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(HystrixDashboardApplication.class).properties("server.port=" + port).run(args);
    }

}
