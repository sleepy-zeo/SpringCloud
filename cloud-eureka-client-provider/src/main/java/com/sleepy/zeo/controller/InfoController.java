package com.sleepy.zeo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Value("${server.port}")
    public String port;

    @RequestMapping("/detail")
    @ResponseBody
    public String detail() {
        return "port: " + port + ", detail: eureka client provider";
    }

}
