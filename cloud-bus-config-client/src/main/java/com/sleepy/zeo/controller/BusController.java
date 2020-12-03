package com.sleepy.zeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bus")
public class BusController {

    private Environment env;

    @Value("${spring.cloud.bus.id}")
    private String serviceId;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @GetMapping("/env")
    @ResponseBody
    public String envValue(@RequestParam("key") String key) {
        return env.getProperty(key, "unknown");
    }

}
