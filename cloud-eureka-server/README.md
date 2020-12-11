## Spring Cloud Eureka

#### eureka server

```text
# 是否把该服务注册到eureka server上，server设置成false，client设置成true
eureka.client.register-with-eureka=false
# 是否从eureka server上拉取当前服务注册的相关信息，server设置成false，client设置成true
eureka.client.fetch-registry=false
# eureka server的注册地址
eureka.client.service-url.defaultZone=http://localhost:${server.port}/eureka/
```

#### eureka client

```text
# 配置client在server中显示的名字
eureka.instance.instance-id=xxx
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:${server.port}/eureka/
```