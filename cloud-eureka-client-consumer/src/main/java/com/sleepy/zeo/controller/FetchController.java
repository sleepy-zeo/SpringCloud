package com.sleepy.zeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/fetch")
public class FetchController {

    private RestTemplate restTemplate;
    private RestTemplate restTemplate2;

    @Autowired
    @Qualifier("normal")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    @Qualifier("balanced")
    public void setRestTemplate2(RestTemplate restTemplate) {
        this.restTemplate2 = restTemplate;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public String detail() {
        System.out.println("detail");
        return restTemplate.getForObject("http://localhost:43000/provider/info/detail", String.class);
    }

    @RequestMapping("/detail2")
    @ResponseBody
    public String detail2() {
        System.out.println("detail2");
        return restTemplate2.getForObject("http://eureka-client-provider/provider/info/detail", String.class);
    }
}
