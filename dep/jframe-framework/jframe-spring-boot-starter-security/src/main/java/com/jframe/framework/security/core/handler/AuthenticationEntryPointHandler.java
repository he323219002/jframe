package com.jframe.framework.security.core.handler;

import com.jframe.base.CommonResult;
import com.jframe.constants.GlobalResponseEnum;
import com.jframe.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Jimmy He
 * @Date: 2023/10/22 20:59
 * @Description: @link #JwtAuthenticationFilter 认证失败会走这里
 *
 */

@Slf4j
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.debug("[commence][访问 URL({}) 时，没有登录]", request.getRequestURI(), authException);
        // 返回 401
        ServletUtils.writeJSON(response, CommonResult.error(GlobalResponseEnum.UNAUTHORIZED));
    }
}
