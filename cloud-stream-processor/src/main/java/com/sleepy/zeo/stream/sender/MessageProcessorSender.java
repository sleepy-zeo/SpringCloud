package com.sleepy.zeo.stream.sender;

import com.sleepy.zeo.stream.MessageProcessor;
import com.sleepy.zeo.stream.message.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(value = MessageProcessor.class)
public class MessageProcessorSender {

    private MessageProcessor messageProcessor;

    @Autowired
    public void setMessageProcessor(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    public void sendMessage(String payload) {
        Message message = MessageBuilder
                .withPayload(payload)
                .build();
        this.messageProcessor.messageOutput().send(message);
    }

    // json -> object
    public void sendUser(String payload) {
        Message message = MessageBuilder
                .withPayload(payload)
                .build();
        this.messageProcessor.userOutput().send(message);
    }

    // object -> object
    public void sendUser(UserMessage userMessage) {
        Message message = MessageBuilder
                .withPayload(userMessage)
                .build();
        this.messageProcessor.userOutput().send(message);
    }
}
