package com.sleepy.zeo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/refresh")
@RefreshScope
public class BusRefreshController {

    @Value("${timestamp}")
    String timestamp;

    @RequestMapping("/timestamp")
    @ResponseBody
    public String timestamp() {
        return "timestamp: " + timestamp;
    }
}
