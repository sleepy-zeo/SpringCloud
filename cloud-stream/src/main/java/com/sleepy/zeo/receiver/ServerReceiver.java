package com.sleepy.zeo.receiver;

import com.sleepy.zeo.stream.SleepyReceiver;
import com.sleepy.zeo.stream.SleepySender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

// EnableBinding主要有两个功能:
// 1. 被注解的类成为一个Configuration，即该类的实例被Spring容器管理
// 2. value对应的类会成为一个Bean，被注入到Spring容器中
@EnableBinding(value = {SleepySender.class, SleepyReceiver.class})
public class ServerReceiver {

    private static final Log logger = LogFactory.getLog(SinkReceiver.class);

    // StreamListener指定了监听的消息通道名
    // SendTo指定返回内容的输出通道
    @StreamListener(value = "sleepy-channel-server")
    @SendTo(value = "sleepy-channel-client")
    public Object receiveMessage(Object payload) {
        logger.info("receiveMessage, payload: " + payload);
        return "message for client: parsed success";
    }
}
