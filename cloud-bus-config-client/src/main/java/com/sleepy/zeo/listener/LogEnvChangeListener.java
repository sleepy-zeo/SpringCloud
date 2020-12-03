package com.sleepy.zeo.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.event.EnvironmentChangeRemoteApplicationEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class LogEnvChangeListener implements ApplicationListener<EnvironmentChangeRemoteApplicationEvent> {

    private static Log log = LogFactory.getLog(LogRefreshListener.class);

    private ContextRefresher contextRefresher;

    @Autowired
    public LogEnvChangeListener(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

    @Override
    public void onApplicationEvent(EnvironmentChangeRemoteApplicationEvent ackRemoteApplicationEvent) {
        Set<String> keys = this.contextRefresher.refresh();
        log.info("Received remote env change request. Env change keys: " + keys);
    }
}
