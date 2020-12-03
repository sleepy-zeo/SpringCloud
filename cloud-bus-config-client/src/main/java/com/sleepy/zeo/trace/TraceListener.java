package com.sleepy.zeo.trace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.event.SentApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class TraceListener {
    private static Log log = LogFactory.getLog(TraceListener.class);
    private BusTraceRepository repository;

    @Autowired
    public void setRepository(BusTraceRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void onAck(AckRemoteApplicationEvent event) {
        this.repository.add(this.getReceivedTrace(event));
    }

    @EventListener
    public void onSend(SentApplicationEvent event) {
        this.repository.add(this.getSentTrace(event));
    }

    private Map<String, Object> getSentTrace(SentApplicationEvent event) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("signal", "spring.cloud.bus.sent");
        map.put("type", event.getType().getSimpleName());
        map.put("id", event.getId());
        map.put("origin", event.getOriginService());
        map.put("destination", event.getDestinationService());
        if (log.isDebugEnabled()) {
            log.debug(map);
        }
        return map;
    }

    private Map<String, Object> getReceivedTrace(AckRemoteApplicationEvent event) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("signal", "spring.cloud.bus.ack");
        map.put("event", event.getEvent().getSimpleName());
        map.put("id", event.getAckId());
        map.put("origin", event.getOriginService());
        map.put("destination", event.getAckDestinationService());
        if (log.isDebugEnabled()) {
            log.debug(map);
        }
        return map;
    }
}
