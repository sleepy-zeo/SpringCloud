## Spring Cloud Bus


#### bus-refresh

```text
// 调用RefreshBusEndpoint.busRefresh()
curl -X POST http://localhost:8899/actuator/bus-refresh

// 调用RefreshBusEndpoint.busRefreshWithDestination(xxx)，其中destination为"微服务名:端口号"
curl -X POST http://localhost:8899/actuator/bus-refresh/{destination}

通过RefreshBusEndpoint源码得知其实就是发送了RefreshRemoteApplicationEvent，然后由RefreshListener接收并处理
```

#### bus-env

```text
// 调用EnvironmentBusEndpoint.busEnv()
curl -X POST -H "Content-Type: application/json" -d '{"name":"info","value":"steven"}' http://localhost:8899/actuator/bus-env

// 调用EnvironmentBusEndpoint.busEnvWithDestination(xxx)，其中destination为"微服务名:端口号"
curl -X POST -H "Content-Type: application/json" -d '{"name":"info","value":"steven"}' http://localhost:8899/actuator/bus-env/{destination}

通过调用EnvironmentBusEndpoint源码得知，其实就是发送了EnvironmentChangeRemoteApplicationEvent，然后由EnvironmentChangeListener接收并处理
```