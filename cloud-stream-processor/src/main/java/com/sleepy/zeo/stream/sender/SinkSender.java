package com.sleepy.zeo.stream.sender;

import com.sleepy.zeo.stream.message.PartitionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;

@EnableBinding(value = Source.class)
public class SinkSender {

    private Source source;

    @Autowired
    public void setSource(Source source) {
        this.source = source;
    }

    public void sendMessage(String payload) {
        Message message = MessageBuilder
                .withPayload(payload)
                .build();
        source.output().send(message);
    }

    public void sendMessage2(String name, String payload, Integer index) {
        source.output().send(new GenericMessage<>(new PartitionMessage(new Date(), name, payload, index)));
    }
}
