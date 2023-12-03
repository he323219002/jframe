package com.jframe.framework.security.core.handler;

import com.jframe.base.CommonResult;
import com.jframe.constants.GlobalResponseEnum;
import com.jframe.utils.ServletUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Jimmy He
 * @Date: 2023/12/3 21:12
 * @Description: 无权限处理器
 */
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 返回 401
        ServletUtils.writeJSON(response, CommonResult.error(GlobalResponseEnum.FORBIDDEN));
    }
}
