package com.example.productdataservice;

import brave.sampler.Sampler;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableEurekaClient    // 表示这是个 EurekaClient
public class ProductDataServiceApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ProductDataServiceApplication.class, args);
        // 启动时设置端口号
        int port = 0;
        final int DEFAULT_PORT = 8001;

        Future<Integer> future = ThreadUtil.execAsync(() -> {
            int p;
            System.out.println("请于5秒钟内输入端口号, 推荐  8001 、 8002  或者  8003，超过5秒将默认使用 " + DEFAULT_PORT);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String strPort = scanner.nextLine();
                if(!NumberUtil.isInteger(strPort)) {
                    System.err.println("只能是数字");
                }
                else {
                    p = Convert.toInt(strPort);
                    scanner.close();
                    break;
                }
            }
            return p;
        });

        try {
            port = future.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            port = DEFAULT_PORT;
        }

        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port);
            System.exit(1);
        }

        new SpringApplicationBuilder(ProductDataServiceApplication.class).properties("server.port=" + port).run(args);
    }

    /**
     * 配置 zipkin 服务链路追踪所需的 Sampler 抽样策略
     * @return 返回 Sampler 抽样策略的 bean
     */
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
