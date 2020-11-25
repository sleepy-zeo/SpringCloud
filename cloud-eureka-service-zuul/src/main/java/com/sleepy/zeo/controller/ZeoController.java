package com.sleepy.zeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/zeo")
public class ZeoController {

    @RequestMapping("/info")
    @ResponseBody
    public String info() {
        return "zuul";
    }
}
