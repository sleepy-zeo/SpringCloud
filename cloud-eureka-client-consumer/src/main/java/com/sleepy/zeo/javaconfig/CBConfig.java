package com.sleepy.zeo.javaconfig;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableDiscoveryClient
public class CBConfig {

    @Bean(value = "normal")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(value = "balanced")
    @LoadBalanced
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }
}
