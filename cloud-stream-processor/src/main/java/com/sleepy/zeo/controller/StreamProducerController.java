package com.sleepy.zeo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
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

    @Autowired
    public void setSource(Source source) {
        this.source = source;
    }

    @RequestMapping("/send")
    public void sendBySource(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("msg") String message) throws IOException {
        source.output().send(MessageBuilder.withPayload(message).build());
        response.getWriter().write("success");
    }
}
