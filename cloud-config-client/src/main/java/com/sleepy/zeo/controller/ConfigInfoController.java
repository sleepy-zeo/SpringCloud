package com.sleepy.zeo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigInfoController {

    @Value("${info}")
    private String info;

    @GetMapping(value = "/info")
    @ResponseBody
    public String info() {
        return info;
    }
}
