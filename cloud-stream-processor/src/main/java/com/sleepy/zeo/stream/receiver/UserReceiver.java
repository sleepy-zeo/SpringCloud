package com.sleepy.zeo.stream.receiver;

import com.sleepy.zeo.stream.MessageProcessor;
import com.sleepy.zeo.stream.message.UserMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(value = MessageProcessor.class)
public class UserReceiver {

    private static final Log logger = LogFactory.getLog(UserReceiver.class);

    @StreamListener(MessageProcessor.USER_INPUT)
    public void handleUser(UserMessage userMessage) {
        logger.info("handleUser, userMessage: " + userMessage);
    }

}
