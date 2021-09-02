# zipkin 服务链路追踪服务器

下载地址：https://how2j.cn/k/springcloud/springcloud-zipkin/2052.html

1、运行

`java -jar zipkin-server-2.10.1-exec.jar`

如果视图服务进行了改造，支持了 RabbitMQ, 那么在默认情况下，它的信息就不会进入 Zipkin 了，需按如下方式执行：

`java -jar zipkin-server-2.10.1-exec.jar --zipkin.collector.rabbitmq.addresses=RabbitMQ的地址`

2、访问

 http://localhost:9411/zipkin/dependency/ 