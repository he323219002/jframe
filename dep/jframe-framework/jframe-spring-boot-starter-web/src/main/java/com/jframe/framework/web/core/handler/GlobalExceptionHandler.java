package com.jframe.framework.web.core.handler;

import com.jframe.base.CommonResult;
import com.jframe.constants.GlobalResponseEnum;
import com.jframe.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/31 23:02
 * @Description: 统一异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
    }

    // todo 这里可以注入日志插入服务记录异常

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResult<?> businessExceptionHandler(BusinessException exception) {
        log.info("[businessExceptionHandler]", exception);
        return CommonResult.error(exception);
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResult<?> defaultExceptionHandler(Exception exception) {
        log.error("[defaultExceptionHandler]", exception);
        return CommonResult.error(GlobalResponseEnum.EXCEPTION);
    }

    /**
     * 处理过滤器异常
     * @param request
     * @param ex
     * @return
     */
    public CommonResult<?> filterExceptionHandler(HttpServletRequest request, Throwable ex){
        return null;
    }
}
