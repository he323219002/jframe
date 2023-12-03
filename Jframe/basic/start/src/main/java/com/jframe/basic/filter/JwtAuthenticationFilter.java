package com.jframe.basic.filter;

import cn.hutool.core.util.StrUtil;
import com.jframe.base.CommonResult;
import com.jframe.constants.GlobalResponseEnum;
import com.jframe.framework.security.config.SecurityProperties;
import com.jframe.framework.security.utils.JwtTokenUtil;
import com.jframe.utils.ServletUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author: Jimmy He
 * @Date: 2023/10/22 20:19
 * @Description: 從jwttoken獲取信息
 */
@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    @Resource
    private SecurityProperties securityProperties;
    @Resource
    private JwtTokenUtil jwtTokenUtil;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // todo 基于请求头获取用户，比如gateway或者其他服务透传获取用户

        String token = request.getHeader(securityProperties.getJwtHeader());

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
        // todo 获取用户
        log.info("username:{}",username);


        chain.doFilter(request, response);
    }
}
