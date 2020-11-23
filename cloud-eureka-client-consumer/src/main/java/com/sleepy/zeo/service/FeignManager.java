package com.sleepy.zeo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client-provider")
public interface FeignManager {
    @RequestMapping("/provider/info/detail")
    String detail();
}
