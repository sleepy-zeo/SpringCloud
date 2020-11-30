package com.sleepy.zeo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class CloudBusConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBusConfigClientApplication.class, args);
    }

    @Value("{info}")
    String info;

    @RequestMapping("/info")
    @ResponseBody
    public String info(){
        return info;
    }
}
