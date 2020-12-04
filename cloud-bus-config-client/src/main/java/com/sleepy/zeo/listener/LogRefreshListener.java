package com.sleepy.zeo.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LogRefreshListener implements ApplicationListener<RefreshRemoteApplicationEvent> {

    private static Log log = LogFactory.getLog(LogRefreshListener.class);

    private ContextRefresher contextRefresher;

    @Autowired
    public LogRefreshListener(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

    public void onApplicationEvent(RefreshRemoteApplicationEvent event) {
        // Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote refresh request. Refreshed keys: " + "");
    }
}