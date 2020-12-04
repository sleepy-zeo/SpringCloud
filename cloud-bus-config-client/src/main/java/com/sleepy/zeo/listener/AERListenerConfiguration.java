package com.sleepy.zeo.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.event.EnvironmentChangeRemoteApplicationEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AERListenerConfiguration {
    private static Log log = LogFactory.getLog(AERListenerConfiguration.class);

    private ContextRefresher contextRefresher;

    @Autowired
    public void setContextRefresher(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

    /**
     * EventListener注解
     *
     * applicationContext调用publishEvent的时候会通过event找到所有的事件监听，然后依次将event发送给事件监听
     * EventListener就是用来注册event的事件监听的
     */
    @EventListener
    public void onAck(AckRemoteApplicationEvent event) {
        // 注销掉是由于这里refresh了后，其它地方就获取不到refresh的keys了
        // 至于其它地方获取不到有什么影响暂时不清楚，好像也没有影响，只要有一个地方去调用refresh操作就可以了
        // Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote ack request. Ack keys: " + "");
    }

    @EventListener
    public void onEnvChange(EnvironmentChangeRemoteApplicationEvent event) {
        // Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote env change request. Env change keys: " + "");
    }

    @EventListener
    public void onRefresh(RefreshRemoteApplicationEvent event) {
        // Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote refresh request. Refreshed keys: " + "");
    }

}
