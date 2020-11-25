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
```

#### Attention

```text
spring-cloud.version必须是有地名的版本号才可以，否则会有很多问题
```