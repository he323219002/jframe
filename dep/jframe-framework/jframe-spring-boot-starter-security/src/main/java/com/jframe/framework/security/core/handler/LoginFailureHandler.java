package com.jframe.framework.security.core.handler;

import com.jframe.base.CommonResult;
import com.jframe.constants.GlobalResponseEnum;
import com.jframe.utils.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Jimmy He
 * @Date: 2023/10/22 19:57
 * @Description: TODO 描述
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 返回 401
        ServletUtils.writeJSON(response, CommonResult.error(GlobalResponseEnum.UNAUTHORIZED));
    }
}
