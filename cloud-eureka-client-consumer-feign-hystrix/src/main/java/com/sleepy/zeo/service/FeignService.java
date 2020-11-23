package com.sleepy.zeo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-client-provider")
public interface FeignService {

    @RequestMapping("/provider/info/detail")
    String detail();
}
