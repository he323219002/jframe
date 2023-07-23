package com.jframe.framework.security.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @Author: Jimmy He
 * @Date: 2023/7/23 18:48
 * @Description: TODO 描述
 */
@AutoConfiguration
@EnableConfigurationProperties(SecurityProperties.class)
public class JframeSecurityAutoConfiguration {

    @Resource
    private SecurityProperties securityProperties;

    /**
     * 密码加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(securityProperties.getPasswordEncoderLength());
    }
}
