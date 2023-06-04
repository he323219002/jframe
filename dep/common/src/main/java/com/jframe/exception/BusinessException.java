package com.jframe.exception;

import java.io.Serial;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/28 22:11
 * @Description: TODO 描述
 */
public class BusinessException extends RuntimeException  {

    @Serial
    private static final long serialVersionUID = -2555751982973992203L;


    /**
     * 获取错误码
     *
     * @return
     */
    private String errorCode;

    /**
     * 获取错误信息
     *
     * @return
     */
    private String errorMsg;

    public BusinessException() {
    }

    public BusinessException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }


    public static BusinessException of(CommonError commonError) {
        return new BusinessException(commonError.errorCode(),commonError.errorMsg());
    }


}
