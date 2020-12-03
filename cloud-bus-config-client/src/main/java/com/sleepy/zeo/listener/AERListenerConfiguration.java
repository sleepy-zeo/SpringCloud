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

import java.util.Set;

@Component
public class AERListenerConfiguration {
    private static Log log = LogFactory.getLog(AERListenerConfiguration.class);

    private ContextRefresher contextRefresher;

    @Autowired
    public void setContextRefresher(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

    @EventListener
    public void onAck(AckRemoteApplicationEvent event) {
        Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote ack request. Ack keys: " + keys);
    }

    @EventListener
    public void onEnvChange(EnvironmentChangeRemoteApplicationEvent event) {
        Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote env change request. Env change keys: " + keys);
    }

    @EventListener
    public void onRefresh(RefreshRemoteApplicationEvent event) {
        Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote refresh request. Refreshed keys: " + keys);
    }

}
