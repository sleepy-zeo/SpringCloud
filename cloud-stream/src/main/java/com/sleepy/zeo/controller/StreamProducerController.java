package com.sleepy.zeo.controller;

import com.sleepy.zeo.stream.message.UserMessage;
import com.sleepy.zeo.stream.sender.MessageProcessorSender;
import com.sleepy.zeo.stream.sender.ProcessorSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ProcessorSender processorSender;
    private MessageProcessorSender messageProcessorSender;

    @Autowired
    public void setProcessorSender(ProcessorSender processorSender) {
        this.processorSender = processorSender;
    }

    @Autowired
    public void setMessageProcessorSender(MessageProcessorSender messageProcessorSender) {
        this.messageProcessorSender = messageProcessorSender;
    }

    @RequestMapping("/send")
    public void sendSource(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("msg") String message) throws IOException {
        processorSender.sendSource(message);
        response.getWriter().write("success");
    }

    @RequestMapping("/send2")
    public void sendSource2(@RequestParam("index") int index, HttpServletResponse response) throws IOException {
        processorSender.sendSource2("ack", "hello world", index);
        response.getWriter().write("success");
    }

    @RequestMapping("/send3")
    public void sendMessage(HttpServletResponse response) throws IOException {
        messageProcessorSender.sendMessage("welcome to sleepy zeo's world");
        response.getWriter().write("success");
    }

    @RequestMapping("/send4")
    public void sendUser(HttpServletResponse response) throws IOException {
        messageProcessorSender.sendUser("{\"name\":\"hangge\",\"age\":100}");
        response.getWriter().write("success");
    }

    @RequestMapping("/send5")
    public void sendUser2(HttpServletResponse response) throws IOException {
        messageProcessorSender.sendUser(new UserMessage("sleepy zeo", 27));
        response.getWriter().write("success");
    }
}
