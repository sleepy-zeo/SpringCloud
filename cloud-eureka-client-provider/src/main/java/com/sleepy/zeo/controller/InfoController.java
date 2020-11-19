package com.sleepy.zeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class InfoController {

    @RequestMapping("/detail")
    @ResponseBody
    public String detail() {
        return "detail: eureka client provider";
    }

}
