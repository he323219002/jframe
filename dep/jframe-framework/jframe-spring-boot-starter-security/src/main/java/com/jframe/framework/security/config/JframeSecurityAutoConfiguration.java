package com.jframe.framework.security.config;

import com.jframe.framework.security.core.handler.AccessDeniedHandlerImpl;
import com.jframe.framework.security.core.handler.AuthenticationEntryPointHandler;
import com.jframe.framework.security.core.handler.LoginFailureHandler;
import com.jframe.framework.security.core.handler.LoginSuccessHandler;
import com.jframe.framework.security.utils.JwtTokenUtil;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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

    /**
     * 认证失败处理类 Bean
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPointHandler();
    }

    /**
     * 权限不够处理器 Bean
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessDeniedHandlerImpl();
    }


    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new LoginFailureHandler();
    }


    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }


}
