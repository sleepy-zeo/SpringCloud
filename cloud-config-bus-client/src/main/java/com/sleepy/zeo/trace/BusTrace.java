package com.sleepy.zeo.trace;

import java.util.Date;
import java.util.Map;

public class BusTrace {
    private final Date timestamp;
    private final Map<String, Object> info;

    public BusTrace(Date timestamp, Map<String, Object> info) {
        this.timestamp = timestamp;
        this.info = info;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public Map<String, Object> getInfo() {
        return this.info;
    }
}
