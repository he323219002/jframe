package com.jframe.framework.web.core.handler;

import com.jframe.base.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @Author: Jimmy He
 * @Date: 2023/6/4 22:14
 * @Description: TODO 描述
 */
@ControllerAdvice
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (Objects.isNull(returnType.getMethod())) {
            return false;
        }
        return returnType.getMethod().getReturnType() == CommonResult.class;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 此处可以统一处理结果
        return body;
    }
}
