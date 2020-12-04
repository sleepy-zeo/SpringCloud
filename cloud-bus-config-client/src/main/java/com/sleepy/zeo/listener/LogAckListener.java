package com.sleepy.zeo.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LogAckListener implements ApplicationListener<AckRemoteApplicationEvent> {

    private static Log log = LogFactory.getLog(LogRefreshListener.class);

    private ContextRefresher contextRefresher;

    @Autowired
    public LogAckListener(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

    @Override
    public void onApplicationEvent(AckRemoteApplicationEvent ackRemoteApplicationEvent) {
        // Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote ack request. Ack keys: " + "");
    }
}
