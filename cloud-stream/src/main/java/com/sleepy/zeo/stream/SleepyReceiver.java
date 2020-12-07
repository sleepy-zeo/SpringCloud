package com.sleepy.zeo.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

// 通过EnableBinding会产生一个名为"sleepyReceiver"的bean
public interface SleepyReceiver {

    // @Input定义输入通道
    // 定义输入通道时，需要返回MessageChannel接口对象，该接口定义了从消息通道接收消息的方法
    @Input("sleepy-channel-client")
    MessageChannel clientInput();

    @Input("sleepy-channel-server")
    MessageChannel serverInput();
}
