package com.example.turbine;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine    // 开启 Turbine
public class TurbineApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TurbineApplication.class, args);
        // 启动时设置端口号
        int port = 8050;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(TurbineApplication.class).properties("server.port=" + port).run(args);
    }

}
