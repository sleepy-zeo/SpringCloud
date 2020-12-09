## Spring Cloud Stream

#### 直接配置RabbitMQ

```yaml
spring:
 rabbitmq:
  host: localhost
  port: 5672
  username: guest
  password: guest
```

#### 通过绑定器取代直接配置RabbitMQ

```yaml
spring:
 cloud:
  stream:
   binders:
    rabbit-env-1:
     type: rabbit
     environment:
      spring:
       rabbitmq:
        host: 192.168.123.1
        port: 5672
        username: guest
        password: guest
    rabbit-env-2:
     type: rabbit
     environment:
      spring:
       rabbitmq:
        host: 192.168.123.2
        port: 5672
        username: guest
        password: guest
```

#### 设置默认的绑定器

```yaml
spring:
 cloud:
  stream:
   default-binder: rabbit-env-1
```

#### 设置特定的绑定器

这里为input通道和output通道单独设置了rabbit-env-2环境配置
```yaml
spring:
 cloud:
  stream:
   bindings:
    input:
     binder: rabbit-env-2
    output:
     binder: rabbit-env-2
```

#### 设置topic

1. topic相当于是将所有具有相同topic名的单向管道(Input管道和Output管道)连通的主管道
2. 每一根管道如果在不设置topic的情况下，框架会默认将管道名设置为管道的topic名
3. 在不设置管道group的情况下，任意一个Input管道发送消息，所有实例中具有相同topic的Output管道都能收到消息

#### 设置group

1. 生产环境中的每个服务都会布置多个实例。通过设置group，绑定到该topic的所有实例的管道同时只会有一个接收到消息
2. 哪一个实例接收到消息是无法确定的


#### topic和group的配置规则

1. 为所有的管道设置topic和group(group只需要配置输入管道)。设置topic是为了让输入输出管道连通，设置group是为了让不同的实例同时只有一个用来处理消息
2. 确定一对输入输出管道，为这对管道设置相同且唯一的topic和group

```yaml
spring:
 cloud:
  stream:
   bindings:
    message_input:
     destination: topic-message
     group: group-message
    message_output:
     destination: topic-message
```

#### 配置partition

配置partition的目的是保证具有共同特征的消息始终由同一个实例接收并处理

##### 配置input
```yaml
spring:
 cloud:
  stream:
   # spring.cloud.stream.instance-count：消费者实例的数量
   # spring.cloud.stream.instance-index：当前消费者实例的索引号
   instance-count: 3
   instance-index: 1
   bindings:
    input:
     destination: publish
     group: publish-group
     # spring.cloud.stream.bindings.<channel>.consumer.partitioned=true开启消息分区
     consumer:
      partitioned: true
```

##### 配置output
```yaml
# 这里count和key有一个取余的算法，index = key % count
# index对应的是消费者实例的索引号，如果不存在该索引，该消息就没有被消费者所消费
spring:
 cloud:
  stream:
   bindings:
    output:
     destination: publish
     producer:
      # spring.cloud.stream.bindings.<channel>.producer.partition-count配置消费分区(消费者实例)的数量
      partition-count: 3
      # spring.cloud.stream.bindings.<channel>.producer.partition-key-expression配置了消息分区键的表达式规则
      partition-key-expression: "payload.partitionId"
```
