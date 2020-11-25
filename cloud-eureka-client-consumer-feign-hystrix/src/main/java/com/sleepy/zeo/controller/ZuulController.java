package com.sleepy.zeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZuulController {

    @RequestMapping("/helloFeign")
    @ResponseBody
    public String hello() {
        return "hello, this is feign.";
    }
}

