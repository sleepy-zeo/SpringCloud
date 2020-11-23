package com.sleepy.zeo.controller;

import com.sleepy.zeo.service.FeignManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * 测试发现consumer最好要在provider全部启动完成后再启动，
 * 否则有几率通过spring.application.name会出现访问失败的问题
 */
@Controller
@RequestMapping("/fetch")
public class FetchController {

    private RestTemplate restTemplate;
    private RestTemplate restTemplate2;

    private FeignManager feignManager;

    @Autowired
    public void setFeignManager(FeignManager feignManager) {
        this.feignManager = feignManager;
    }

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
        return restTemplate.getForObject("http://localhost:10033/provider/info/detail", String.class);
    }

    @RequestMapping("/detail2")
    @ResponseBody
    public String detail2() {
        System.out.println("detail2");
        return restTemplate2.getForObject("http://eureka-client-provider/provider/info/detail", String.class);
    }

    @RequestMapping("/detail3")
    @ResponseBody
    public String detail3() {
        System.out.println("detail3");
        return feignManager.detail();
    }
}
