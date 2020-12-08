package com.sleepy.zeo.controller;

import com.sleepy.zeo.stream.MessageProcessor;
import com.sleepy.zeo.stream.message.UserMessage;
import com.sleepy.zeo.stream.sender.SinkSender;
import com.sleepy.zeo.stream.sender.UserSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/stream")
public class StreamProducerController {

    private static final Log logger = LogFactory.getLog(StreamProducerController.class);

    private Source source;
    private MessageProcessor messageProcessor;
    private SinkSender sinkSender;
    private UserSender userSender;

    @Autowired
    public void setSource(Source source) {
        this.source = source;
    }

    @Autowired
    public void setMessageProcessor(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @Autowired
    public void setSinkSender(SinkSender sinkSender) {
        this.sinkSender = sinkSender;
    }

    @Autowired
    public void setUserSender(UserSender userSender) {
        this.userSender = userSender;
    }

    @RequestMapping("/send")
    public void sendBySource(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("msg") String message) throws IOException {
        source.output().send(MessageBuilder.withPayload(message).build());
        response.getWriter().write("success");
    }

    @RequestMapping("/send2")
    public void send2() {
        Message message = MessageBuilder
                .withPayload("welcome to sleepy zeo's world")
                .build();
        messageProcessor.messageOutput().send(message);
    }

    @RequestMapping("/send3")
    public void send3() {
        sinkSender.sendMessage("hello world");
    }

    @RequestMapping("/send4")
    public void send4(@RequestParam("index") int index) {
        sinkSender.sendMessage2("ack", "hello world", index);
    }

    @RequestMapping("/send5")
    public void send5() {
        userSender.sendMessage("{\"name\":\"hangge\",\"age\":100}");
    }

    @RequestMapping("/send6")
    public void send6() {
        userSender.sendMessage2(new UserMessage("sleepy zeo", 27));
    }
}
