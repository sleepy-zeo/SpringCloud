package com.sleepy.zeo.receiver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

// EnableBinding主要有两个功能:
// 1. 被注解的类成为一个Configuration，即该类的实例被Spring容器管理
// 2. value对应的类会成为一个Bean，被注入到Spring容器中
@EnableBinding(value = {Sink.class, Source.class})
public class SinkReceiver {

    private static final Log logger = LogFactory.getLog(SinkReceiver.class);

    // StreamListener指定了监听的消息通道名
    @StreamListener(value = Sink.INPUT)
    public void receiveMessage(Object payload) {
        logger.info("receiveMessage, payload: " + payload);
    }
}
