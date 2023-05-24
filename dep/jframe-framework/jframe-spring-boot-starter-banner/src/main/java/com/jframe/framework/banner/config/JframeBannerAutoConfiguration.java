package com.jframe.framework.banner.config;

import com.jframe.framework.banner.core.BannerApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/23 22:41
 * @Description: TODO 描述
 */
@AutoConfiguration
public class JframeBannerAutoConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner(){
        return new BannerApplicationRunner();
    }
}
