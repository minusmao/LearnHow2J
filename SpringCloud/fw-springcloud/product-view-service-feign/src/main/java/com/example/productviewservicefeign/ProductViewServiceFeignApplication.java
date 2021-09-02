package com.example.productviewservicefeign;

import brave.sampler.Sampler;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableEurekaClient       // 表示这是个 EurekaClient
@EnableDiscoveryClient    // 表示用于发现 Eureka 注册中心的微服务
@EnableFeignClients       // 表示向数据服务发送请求时，使用 Feign 方式
@EnableCircuitBreaker     // 把信息共享给监控中心
public class ProductViewServiceFeignApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ProductViewServiceFeignApplication.class, args);
        // 启动时设置端口号
        int port = 0;
        int defaultPort = 8020;
        Future<Integer> future = ThreadUtil.execAsync(() ->{
            int p = 0;
            System.out.println("请于5秒钟内输入端口号, 推荐  8020  超过5秒将默认使用 " + defaultPort);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String strPort = scanner.nextLine();
                if(!NumberUtil.isInteger(strPort)) {
                    System.err.println("只能是数字");
                    continue;
                }
                else {
                    p = Convert.toInt(strPort);
                    scanner.close();
                    break;
                }
            }
            return p;
        });

        try{
            port=future.get(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException | ExecutionException | TimeoutException e){
            port = defaultPort;
        }

        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductViewServiceFeignApplication.class).properties("server.port=" + port).run(args);
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
