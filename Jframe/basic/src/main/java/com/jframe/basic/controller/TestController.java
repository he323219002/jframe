package com.jframe.basic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${app}")
    private Integer app;

    @GetMapping("/get")
    private String getConfig(){
        return String.valueOf(app);
    }
}
