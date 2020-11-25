package com.sleepy.zeo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public String detail() {
        System.out.println("detail");
        return restTemplate.getForObject("http://localhost:3800/provider/info/detail", String.class);
    }

    @RequestMapping("/detail2")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public String detail2() {
        System.out.println("detail2");
        return restTemplate2.getForObject("http://eureka-client-provider/provider/info/detail", String.class);
    }

    // 访问zuul的一个路由接口，最终访问的是ZuulController的helloRibbon接口
    @RequestMapping("/detail3")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public String detail3() {
        System.out.println("detail2");
        return restTemplate2.getForObject("http://eureka-service-zuul/zuul/route/ribbon/consumer/helloRibbon", String.class);
    }

    public String hystrixFallback() {
        return "Hystrix in ribbon.";
    }
}
