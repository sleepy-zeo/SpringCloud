## Spring Cloud Zuul
默认情况下，Eureka上所有注册的服务都会被zuul创建映射关系来进行路由

#### 路由转发
zuul的主要功能之一是路由转发，比如将/api/user转发到user服务组件中，将/api/shop转发到到shop服务组件中

```
# 系统提供的默认配置
zuul.routes.feign-consumer.path=/feign-consumer/**
zuul.routes.feign-consumer.serviceId=feign-consumer

# 一般手动的路由配置
zuul.routes.api-feign.path=/api-feign/**
zuul.routes.api-feign.serviceId=feign-consumer

# 简化版本的手动配置
zuul.routes.feign-consumer=/api-feign/**

```


#### 过滤
zuul的主要功能之二是过滤，比如拦截/api/user等url做一些安全性验证，验证通过才转发到user中，验证不通过直接拦截该request

```

```