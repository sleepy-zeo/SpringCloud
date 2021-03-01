package com.sleepy.zeo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client-provider",
        fallback = FeignServiceHystrixFallback.class)
public interface FeignService {

    @GetMapping("/provider/info/detail")
    String detail();

}
