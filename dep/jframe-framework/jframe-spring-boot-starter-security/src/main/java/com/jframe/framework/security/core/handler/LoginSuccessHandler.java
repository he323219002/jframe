package com.jframe.framework.security.core.handler;

import com.jframe.framework.security.config.SecurityProperties;
import com.jframe.framework.security.utils.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Jimmy He
 * @Date: 2023/10/22 11:14
 * @Description: 登录成功处理
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // 生成JWT，并放置到请求头中
        String jwt = jwtTokenUtil.generateToken(authentication.getName());
        response.setHeader(jwtTokenUtil.generateToken(securityProperties.getJwtHeader()), jwt);

    }
}
