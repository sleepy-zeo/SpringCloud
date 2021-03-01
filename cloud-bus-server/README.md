## Spring Cloud Bus

#### bus-refresh

```text
// 调用RefreshBusEndpoint.busRefresh()
curl -X POST http://localhost:8899/actuator/bus-refresh

// 调用RefreshBusEndpoint.busRefreshWithDestination(xxx)，其中destination为"微服务名:端口号"
curl -X POST http://localhost:8899/actuator/bus-refresh/{destination}
```

1. 通过actuator模块，调用url实际上是调用了RefreshBusEndpoint的相关方法
2. 通过RefreshBusEndpoint源码得知其实就是发送了RefreshRemoteApplicationEvent，然后由RefreshListener接收并处理
3. 当application.yml配置文件中的属性值改变时候，contextRefresher的refresh()就能检测到相应改变，触发@RefreshScope热加载


#### bus-env

```text
// 调用EnvironmentBusEndpoint.busEnv()
curl -X POST -H "Content-Type: application/json" -d '{"name":"info","value":"steven"}' http://localhost:8899/actuator/bus-env

// 调用EnvironmentBusEndpoint.busEnvWithDestination(xxx)，其中destination为"微服务名:端口号"
curl -X POST -H "Content-Type: application/json" -d '{"name":"info","value":"steven"}' http://localhost:8899/actuator/bus-env/{destination}
```

1. 通过actuator模块，调用url实际上是调用了EnvironmentBusEndpoint的相关方法
2. 通过调用EnvironmentBusEndpoint源码得知，其实就是发送了EnvironmentChangeRemoteApplicationEvent，然后由EnvironmentChangeListener接收并处理
3. 上述方法实质上实现了添加/修改当前运行环境中environment中变量的值