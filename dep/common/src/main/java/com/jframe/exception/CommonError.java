package com.jframe.exception;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/28 22:52
 * @Description: TODO 描述
 */
public interface CommonError {

    /**
     * 获取错误码
     * @return
     */
    String errorCode();

    /**
     * 获取错误信息
     * @return
     */
    String errorMsg();

}
