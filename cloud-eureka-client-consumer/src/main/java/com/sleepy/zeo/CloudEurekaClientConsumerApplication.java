package com.sleepy.zeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudEurekaClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClientConsumerApplication.class, args);
    }

}
