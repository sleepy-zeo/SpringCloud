package com.sleepy.zeo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// RefreshScope: 在需要刷新的属性对应的类上添加此注解
@RefreshScope
@Controller
@RequestMapping("/refresh")
public class RefreshController {

    @Value("${info}")
    String info;

    @Value("${server.port}")
    String port;

    @Value("${config.client.version}")
    String version;

    @RequestMapping("/info")
    @ResponseBody
    public String info() {
        return info + ", " + port + ", " + version;
    }
}
