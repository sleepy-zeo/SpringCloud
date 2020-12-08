#### RabbitMQ的一般配置

```yaml
spring:
 rabbitmq:
  host: localhost
  port: 5672
  username: guest
  password: guest
```

#### 配置多个绑定器环境

取代了上文的RabbitMQ环境的配置
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

topic相当于是将所有具有相同topic的单向管连通的主管道，每一根管道默认都有一个topic，只是如果在不设置的情况下，topic名即为管道的名称

???这个理解是否正确