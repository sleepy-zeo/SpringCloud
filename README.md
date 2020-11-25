## Spring Cloud
this is Spring Cloud

#### Pronunciation

```text
Eureka      [juˈriːkə] 
Ribbon      [ˈrɪbən]
Feign       [feɪn]
Hystrix     [hɪst'rɪks]
Zuul        [zulu]
Sleuth      [sluθ]
Turbine     [ˈtɜ:rbaɪn]
```

#### Ports

```text
server:                                             1124
eureka-service-zuul:                                1984
eureka-client-provider:                             3800
eureka-client-consumer-ribbon-hystrix:              4750
eureka-client-consumer-feign-hystrix:               4751
config-server:                                      8888(该端口值目前只能是8888)

```

#### Attention

```text
spring-cloud.version必须是有地名的版本号才可以，否则会有很多问题
```


##### config

```text
# 获取所有相关文件的信息
/{application}/{profile}[/{label}]
# 获取特定文件的信息
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties 

application     表示应用名称，在client中通过spring.config.name配置
profile         表示获取指定环境下配置，默认为default，可以是任意字符串，一般约定是dev/test/pro三种
label           默认值master
```