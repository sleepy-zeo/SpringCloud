package com.sleepy.zeo.stream.message;

import java.util.Date;

public class PartitionMessage {

    private Date date;
    private String name;
    private String payload;
    private Integer partitionId;

    public PartitionMessage() {

    }

    public PartitionMessage(Date date, String name, String payload, Integer partitionId) {
        this.date = date;
        this.name = name;
        this.payload = payload;
        this.partitionId = partitionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(Integer partitionId) {
        this.partitionId = partitionId;
    }

    @Override
    public String toString() {
        return "PartitionMessage[" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", payload='" + payload + '\'' +
                ", partitionId=" + partitionId +
                ']';
    }
}
