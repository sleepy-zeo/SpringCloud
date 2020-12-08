package com.sleepy.zeo.stream.receiver;

import com.sleepy.zeo.stream.MessageProcessor;
import com.sleepy.zeo.stream.message.UserMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

@EnableBinding(value = MessageProcessor.class)
public class UserReceiver {

    private static final Log logger = LogFactory.getLog(UserReceiver.class);

    @StreamListener(MessageProcessor.USER_INPUT)
    public void handleUser(UserMessage userMessage) {
        logger.info("handleUser, userMessage: " + userMessage);
    }

    // TODO: bugs
    @StreamListener(MessageProcessor.USER_INPUT)
    public void handleUser(byte[] bytes) throws IOException, ClassNotFoundException {
        logger.info("handleUser, byte[]: " + Arrays.toString(bytes));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        UserMessage userMessage = (UserMessage) objectInputStream.readObject();

        logger.info("handleUser, byte[]: " + userMessage);
    }
}
