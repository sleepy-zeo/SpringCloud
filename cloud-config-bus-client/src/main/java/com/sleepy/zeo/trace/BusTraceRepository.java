package com.sleepy.zeo.trace;

import java.util.List;
import java.util.Map;

public interface BusTraceRepository {

    List<BusTrace> findAll();

    void add(Map<String, Object> map);
}
