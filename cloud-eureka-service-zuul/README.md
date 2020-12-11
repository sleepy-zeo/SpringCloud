## Spring Cloud Zuul
1. zuul只用来做服务的转发，不用来做页面、静态资源的转发(所以只针对@ResponseBody的request)
2. zuul使得eureka上所有注册的服务都会默认创建路由映射

#### 路由
zuul的主要功能之一是路由转发，比如将/api/user转发到user服务组件中，将/api/shop转发到到shop服务组件中

```properties
# 系统提供的默认配置
zuul.routes.feign-consumer.path=/feign-consumer/**
zuul.routes.feign-consumer.serviceId=feign-consumer

# 一般手动的路由配置
zuul.routes.api-feign.path=/api-feign/**
zuul.routes.api-feign.serviceId=feign-consumer

# 简化版本的手动配置
zuul.routes.feign-consumer=/api-feign/**

# zuul默认会为所有eureka上的服务创建映射关系，通过zuul.ignored-services取消某些服务的默认创建行为
zuul.ignored-services=config-service
```


#### 过滤
zuul的主要功能之二是过滤，过滤的url是需要路由的url，普通的url不会被拦截

```java
RequestContext requestContext = RequestContext.getCurrentContext();
HttpServletRequest httpServletRequest = requestContext.getRequest();

// 如果需要拦截处理
requestContext.setSendZuulResponse(false);
requestContext.setResponseStatusCode(401);
requestContext.getResponse().getWriter().write("token is empty")
return null;
// 如果不需要拦截处理
return null;
```
