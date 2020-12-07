package com.sleepy.zeo.controller;

import com.sleepy.zeo.stream.SleepySender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/produce")
@EnableBinding(value = Source.class)
public class StreamProducerController {

    private static final Log logger = LogFactory.getLog(StreamProducerController.class);

    private SleepySender sleepySender;

    @Autowired
    public void setSleepySender(SleepySender sleepySender) {
        this.sleepySender = sleepySender;
    }

    @RequestMapping("/send")
    public void send(HttpServletRequest request, HttpServletResponse response,
                     @RequestParam("msg") String message) throws IOException {
        sleepySender.serverOutput().send(MessageBuilder.withPayload(message).build());
        response.getWriter().write("success");
    }

    @StreamListener(value = "sleepy-channel-client")
    public void receiveMessage(Object payload) {
        logger.info("receiveMessage, payload: " + payload);
    }

    private Source source;

    @Autowired
    public void setSource(Source source) {
        this.source = source;
    }

    @RequestMapping("/source")
    public void sendBySource(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("msg") String message) throws IOException {
        source.output().send(MessageBuilder.withPayload(message).build());
        response.getWriter().write("success");
    }

}
