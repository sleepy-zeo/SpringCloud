package com.sleepy.zeo.stream.receiver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

// EnableBinding主要有两个功能:
// 1. 被注解的类成为一个Configuration，即该类的实例被Spring容器管理
// 2. value对应的类会成为一个Bean，被注入到Spring容器中
@EnableBinding(value = {Sink.class})
public class ProcessorReceiver {

    private static final Log logger = LogFactory.getLog(ProcessorReceiver.class);

    // StreamListener指定了监听的消息通道名
    @StreamListener(value = Sink.INPUT)
    public void receiveMessage(Object payload) {
        logger.info("receiveMessage, payload: " + payload);
    }
}
