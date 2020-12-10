package com.sleepy.zeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/env")
public class BusEnvironmentController {

    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @GetMapping("/prop")
    @ResponseBody
    public String envValue(@RequestParam("key") String envKey) {
        return env.getProperty(envKey, "unknown env value for envKey: " + envKey);
    }
}
