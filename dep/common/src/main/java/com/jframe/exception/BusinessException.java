package com.jframe.exception;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/28 22:11
 * @Description: TODO 描述
 */
public class BusinessException extends RuntimeException {
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
        super();
    }

    public BusinessException of(CommonError commonError) {
        BusinessException exception = new BusinessException();
        exception.errorCode = commonError.errorCode();
        exception.errorMsg = commonError.errorMsg();
        return exception;
    }
}
