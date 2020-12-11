## Spring Cloud Config

分布式系统的服务数量非常多，每个服务又对应一个配置文件。于是我们可以通过spring cloud config将所有服务的配置文件统一到一个地方(可以是本地、可以是远程仓库)进行管理

#### config-server

server端需要添加@EnableConfigServer注解
```properties
# 默认config server的端口是8888
server.port = 8888

# 配置文件的分支，这里是git的main分支，默认为default分支
spring.cloud.config.label = main
# 配置文件存储地址的相关信息
spring.cloud.config.server.git.uri = https://github.com/sleepy-zeo/spring-cloud-configs
spring.cloud.config.server.git.search-paths = config-files
spring.cloud.config.server.git.username = xxx
spring.cloud.config.server.git.password = xxx
```


#### config-client

1. 以下内容存放在bootstrap.yml(bootstrap.properties)中
2. client的dependency中一定要有spring-boot-starter-web依赖

```properties
# 对应的文件是main分支的config-client-dev.yml文件
spring.cloud.config.uri = http://localhost:8888/
spring.cloud.config.name = config-client
spring.cloud.config.profile = dev
spring.cloud.config.label = main
```