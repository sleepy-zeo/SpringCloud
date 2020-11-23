package com.sleepy.zeo.controller;

import com.sleepy.zeo.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fetch")
public class FeignController {

    private FeignService feignService;

    @Autowired
    public void setFeignService(FeignService feignService) {
        this.feignService = feignService;
    }

    @RequestMapping("/info")
    @ResponseBody
    public String info() {
        return feignService.detail();
    }
}
