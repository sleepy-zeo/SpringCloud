package com.sleepy.zeo.trace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusConfiguration {

    @Bean
    public BusTraceRepository getRepository() {
        return new BusTraceRepositoryImpl();
    }
}
