package com.sleepy.zeo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StaticController {
    private static final Log logger = LogFactory.getLog(StaticController.class);


    @RequestMapping("/static/**")
    public String src(HttpServletRequest request){
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        logger.info("path: " + path);

        return "forward:/" + path.substring(8);
    }
}
