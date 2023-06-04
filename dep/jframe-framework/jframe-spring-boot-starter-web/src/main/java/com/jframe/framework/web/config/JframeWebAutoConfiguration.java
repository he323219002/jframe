package com.jframe.framework.web.config;

import com.jframe.framework.web.core.handler.GlobalExceptionHandler;
import com.jframe.framework.web.core.handler.GlobalResponseBodyHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/31 23:59
 * @Description: TODO 描述
 */
@AutoConfiguration
public class JframeWebAutoConfiguration implements WebMvcConfigurer {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

    @Bean
    public GlobalResponseBodyHandler globalResponseBodyHandler(){
        return new GlobalResponseBodyHandler();
    }
}
