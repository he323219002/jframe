package com.jframe.framework.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @Author: Jimmy He
 * @Date: 2023/7/23 18:42
 * @Description: TODO 描述
 */
@ConfigurationProperties(prefix = "jframe.security")
@Data
@Validated
public class SecurityProperties {

    /**
     * PasswordEncoder 加密复杂度，越高开销越大
     */
    private Integer passwordEncoderLength = 4;

    /**
     * 过期时间：秒级
     */
    private Long jwtExpire;

    private String jwtSecret;

    private String jwtHeader;
}
