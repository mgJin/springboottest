package com.mgjinproject.showstack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger Logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello(){
        return "Hallo Worlds!!";
    }

    @PostMapping("/log-test")
    public void logTest(){
        Logger.trace("Tracelog");
        Logger.debug("Debug");
        Logger.info("infofdgjskldfgj;lsdfkjg");
        Logger.warn("warn");
        Logger.error("error");
    }
}
