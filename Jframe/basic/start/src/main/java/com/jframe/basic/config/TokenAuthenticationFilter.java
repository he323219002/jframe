package com.jframe.basic.config;

import cn.hutool.core.util.StrUtil;
import com.jframe.base.CommonResult;
import com.jframe.constants.GlobalResponseEnum;
import com.jframe.framework.security.config.SecurityProperties;
import com.jframe.framework.security.spi.BaseTokenAuthenticationFilter;
import com.jframe.framework.security.utils.JwtTokenUtil;
import com.jframe.utils.ServletUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author: Jimmy He
 * @Date: 2023/12/16 18:05
 * @Description: TODO 描述
 */
@Component
@Slf4j
public class TokenAuthenticationFilter extends BaseTokenAuthenticationFilter {

    @Resource
    private SecurityProperties securityProperties;
    @Resource
    private JwtTokenUtil jwtTokenUtil;




    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // todo 基于请求头获取用户，比如gateway或者其他服务透传获取用户

        String token = request.getHeader(securityProperties.getHeader());

        // 若无，则为匿名访问，交给鉴权管理器
        if (StrUtil.isEmpty(token)) {
            chain.doFilter(request, response);
        }
        Claims claim = jwtTokenUtil.getClaimsByToken(token);
        if (Objects.isNull(claim)) {
            log.error("token校验失败");
            ServletUtils.writeJSON(response, CommonResult.error(GlobalResponseEnum.UNAUTHORIZED));
        }
        if (jwtTokenUtil.isTokenExpired(claim)){
            log.error("token已过期");
            ServletUtils.writeJSON(response, CommonResult.error(GlobalResponseEnum.UNAUTHORIZED));
        }

        String username = claim.getSubject();
        // todo 获取用户放在主工程里（依赖于获取用户的服务），后期提供一个专门的api用来提供，才可以集成到starter


        chain.doFilter(request, response);
    }

}
