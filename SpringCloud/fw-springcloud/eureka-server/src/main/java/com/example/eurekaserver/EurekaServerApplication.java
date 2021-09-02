package com.example.eurekaserver;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer    // 表示这是个 EurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EurekaServerApplication.class, args);

        //8761 这个端口是默认的，就不要修改了，后面的子项目，都会访问这个端口。
        int port = 8761;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        // 按指定端口启动
        new SpringApplicationBuilder(EurekaServerApplication.class).properties("server.port=" + port).run(args);
    }

}
