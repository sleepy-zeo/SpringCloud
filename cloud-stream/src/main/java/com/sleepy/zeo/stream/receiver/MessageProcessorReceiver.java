package com.sleepy.zeo.stream.receiver;

import com.sleepy.zeo.stream.MessageProcessor;
import com.sleepy.zeo.stream.message.UserMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EnableBinding(value = MessageProcessor.class)
public class MessageProcessorReceiver {

    private static final Log logger = LogFactory.getLog(MessageProcessor.class);

    // SendTo将返回值发送到指定的通道
    @StreamListener(MessageProcessor.MESSAGE_INPUT)
    @SendTo(MessageProcessor.LOG_OUTPUT)
    public String processMessage(String message) {
        logger.info("processMessage msg: " + message);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String now = LocalDateTime.now().format(formatter2);
        return "data: " + now;
    }

    @StreamListener(MessageProcessor.LOG_INPUT)
    public void processLog(String message) {
        logger.info("processLog log: " + message);
    }

    @StreamListener(MessageProcessor.USER_INPUT)
    public void handleUser(UserMessage userMessage) {
        logger.info("handleUser, userMessage: " + userMessage);
    }

}
