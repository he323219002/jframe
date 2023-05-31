package com.jframe.base;

import com.jframe.constants.GlobalResponseConstant;
import com.jframe.exception.BusinessException;
import com.jframe.exception.CommonError;
import org.springframework.util.Assert;

import java.io.Serial;
import java.net.http.HttpResponse;
import java.nio.charset.CoderResult;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/28 23:08
 * @Description: 通用响应
 */
public class CommonResult<T> extends Dto {

    @Serial
    private static final long serialVersionUID = 207203400807630572L;

    private String code;

    private T data;

    private String msg;

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(GlobalResponseConstant.SUCCESS_CODE);
        result.setData(data);
        result.setMsg(GlobalResponseConstant.SUCCESS);
        return result;
    }

    public static <T> CommonResult<T> error(String errorCode, String errorMsg) {
        Assert.isTrue(!GlobalResponseConstant.SUCCESS.equals(errorCode), "code码必须错误");
        CommonResult<T> result = new CommonResult<>();
        result.code = errorCode;
        result.msg = errorMsg;
        return result;
    }

    public static <T> CommonResult<T> error(BusinessException error) {
        CommonResult<T> result = new CommonResult<>();
        result.code = error.getErrorCode();
        result.msg = error.getErrorMsg();
        return result;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
