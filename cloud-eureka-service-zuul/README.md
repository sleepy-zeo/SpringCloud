## Spring Cloud Zuul

1. zuul的主要功能之一是路由转发，比如将/api/user转发到user服务组件中，将/api/shop转发到到shop服务组件中
2. zuul的主要功能之二是过滤，比如拦截/api/user等url做一些安全性验证，验证通过才转发到user中，验证不通过直接拦截该request
3. 默认情况下，Eureka上所有注册的服务都会被Zuul创建映射关系来进行路由