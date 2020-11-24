package com.sleepy.zeo.service;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystrixFallback implements FeignService {

    @Override
    public String detail() {
        return "Hystrix in feign.";
    }
}
