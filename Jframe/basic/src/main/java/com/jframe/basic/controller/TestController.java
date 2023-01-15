package com.jframe.basic.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Slf4j
public class TestController {

    @Value("${app.name}")
    private String app;

    @GetMapping("/get")
    public String getConfig(){
        log.info("app:{}",app);
        return app;
    }

    @GetMapping("/post")
    public String getConfig2(){

        return "test post";
    }
}
