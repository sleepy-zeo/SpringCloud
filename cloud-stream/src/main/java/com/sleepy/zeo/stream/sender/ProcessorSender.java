package com.sleepy.zeo.stream.sender;

import com.sleepy.zeo.stream.message.PartitionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;

@EnableBinding(value = Source.class)
public class ProcessorSender {

    private Source source;

    @Autowired
    public void setSource(Source source) {
        this.source = source;
    }

    // partition-key-expression表明payload必须要有partitionId属性，否则报错
    public void sendSource(String payload) {
        Message message = MessageBuilder
                .withPayload(payload)
                .build();
        source.output().send(message);
    }

    public void sendSource2(String name, String payload, Integer index) {
        Message message = MessageBuilder
                .withPayload(new PartitionMessage(new Date(), name, payload, index))
                .build();
        source.output().send(message);
    }
}
