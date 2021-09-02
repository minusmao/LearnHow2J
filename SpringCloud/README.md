# Spring Cloud 各个微服务与端口

## 一、微服务

### 1. eureka-server: 8761

注册中心，本地运行时访问：http://localhost:8761/

### 2. product-data-service: 8001,8002,8003

数据服务，本地运行时访问：http://localhost:8001/products

### 3. product-view-service-ribbon: 8010

视图服务，本地运行时访问：http://localhost:8010/products

### 4. product-view-service-feign: 8020, 8021

视图服务，本地运行时访问：http://localhost:8020/products

### 5. config-server: 8030

配置中心，调用 product-view-service-feign 项目中的 FreshConfigUtil 工具类更新配置信息

### 6. hystrix-dashboard: 8040

断路器监控，本地运行时访问：http://localhost:8040/hystrix 来监控微服务，在页面输入框输入要监控的微服务：http://微服务地址:端口/actuator/hystrix.stream

### 7. turbine: 8050

断路器监控，本地运行时访问：http://localhost:8040/hystrix 来监控微服务，在页面输入框输入：http://localhost:8050/turbine.stream 即可监控所有在 turbine 中配置好的微服务

### 9. zuul: 8060

网关，已配置好数据服务和视图服务，如果要访问数据服务，访问地址 http://localhost:8060/api-data/products 即可，如果要访问视图服务，访问地址 http://localhost:8060/api-view/products 即可

## 二、第三方

### 1. zipkin: 9411

服务追踪，运行：`java -jar zipkin-server-2.10.1-exec.jar --zipkin.collector.rabbitmq.addresses=RabbitMQ的地址`，访问：http://localhost:9411/zipkin/dependency/ 

### 2. RabbitMQ: 5672

消息队列，图形化界面端口为：15672，账号：guest，密码：guest
