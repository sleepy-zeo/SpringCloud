package com.sleepy.zeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/fetch")
public class FetchController {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
    @RequestMapping("/info/detail")
    @ResponseBody
    public String detail() {
        return restTemplate.getForObject("http://localhost:10011/info/detail", String.class);
    }
    */

    @RequestMapping("/info/detail2")
    @ResponseBody
    public String detail2() {
        return restTemplate.getForObject("http://eureka-client-provider/info/detail", String.class);
    }
}
