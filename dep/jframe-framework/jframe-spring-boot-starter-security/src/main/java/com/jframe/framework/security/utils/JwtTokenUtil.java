package com.jframe.framework.security.utils;

import com.jframe.framework.security.config.SecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * @Author: Jimmy He
 * @Date: 2023/10/22 10:23
 * @Description: jwtToken工具类
 */


@Slf4j
public class JwtTokenUtil {

    @Resource
    private SecurityProperties securityProperties;

    /**
     * 生成JWT
     * @param username
     * @return
     */
    public String generateToken(String username) {


        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + 1000 * securityProperties.getExpire());

        SecretKey secretKey = generalKey();

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(username)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(secretKey,SignatureAlgorithm.HS512)
                .compact();
    }


    /**
     * 解析JWT
     * @param jwt
     * @return
     */
    public Claims getClaimsByToken(String jwt) {
        try {
            return Jwts.parserBuilder().setSigningKey(generalKey())
                    .build()
                    . parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            log.error("解析token错误");
            return null;
        }
    }

    /**
     * 判断JWT是否过期
     * @param claims
     * @return
     */
    public boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }


    /**
     * 由字符串生成加密key
     *
     * @return SecretKey
     */
    public SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(securityProperties.getSecret());
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA512");
    }


}
