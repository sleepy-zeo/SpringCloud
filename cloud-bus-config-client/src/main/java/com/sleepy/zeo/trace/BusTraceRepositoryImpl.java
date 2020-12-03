package com.sleepy.zeo.trace;

import java.util.*;

public class BusTraceRepositoryImpl implements BusTraceRepository {

    private int capacity = 100;
    private boolean reverse = true;
    private final List<BusTrace> traces = new LinkedList();

    public void setReverse(boolean reverse) {
        synchronized (this.traces) {
            this.reverse = reverse;
        }
    }

    public void setCapacity(int capacity) {
        synchronized (this.traces) {
            this.capacity = capacity;
        }
    }

    @Override
    public List<BusTrace> findAll() {
        synchronized (this.traces) {
            return Collections.unmodifiableList(new ArrayList<>(this.traces));
        }
    }

    @Override
    public void add(Map<String, Object> map) {
        BusTrace trace = new BusTrace(new Date(), map);
        synchronized (this.traces) {
            while (this.traces.size() >= this.capacity) {
                this.traces.remove(this.reverse ? this.capacity - 1 : 0);
            }

            if (this.reverse) {
                this.traces.add(0, trace);
            } else {
                this.traces.add(trace);
            }

        }
    }
}
