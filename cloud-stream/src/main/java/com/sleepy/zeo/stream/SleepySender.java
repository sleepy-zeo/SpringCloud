package com.sleepy.zeo.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

// 通过EnableBinding会产生一个名为"sleepySender"的bean
public interface SleepySender {

    // @Output定义输出通道
    // 定义输出通道的时候，需要返回MessageChannel接口对象，该接口定义了向消息通道发送消息的方法
    @Output("sleepy-channel-client")
    MessageChannel clientOutput();

    @Output("sleepy-channel-server")
    MessageChannel serverOutput();
}
