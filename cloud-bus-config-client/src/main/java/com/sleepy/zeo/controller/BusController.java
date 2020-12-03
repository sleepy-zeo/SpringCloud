package com.sleepy.zeo.controller;

import com.sleepy.zeo.trace.BusTrace;
import com.sleepy.zeo.trace.BusTraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/bus")
public class BusController {

    private Environment env;
    private BusTraceRepository repository;

    @Autowired
    public void setRepository(BusTraceRepository repository) {
        this.repository = repository;
    }

    @Value("${spring.cloud.bus.id}")
    private String serviceId;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @GetMapping("/env")
    @ResponseBody
    public String envValue(@RequestParam("key") String key) {
        return env.getProperty(key, "unknown");
    }

    @RequestMapping(value = "/trace")
    @ResponseBody
    public List<BusTrace> trace(HttpServletRequest request) throws IOException {
        return repository.findAll();
    }
}
