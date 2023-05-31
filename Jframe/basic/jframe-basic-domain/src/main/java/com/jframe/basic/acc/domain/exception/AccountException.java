package com.jframe.basic.acc.domain.exception;

import com.jframe.exception.CommonError;

/**
 * @Author: Jimmy He
 * @Date: 2023/6/1 00:30
 * @Description: TODO 描述
 */
public enum AccountException implements CommonError {
    TEST("4444111","zxcv"),
    ;

    private String code;

    private String msg;

    AccountException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String errorCode() {
        return code;
    }

    @Override
    public String errorMsg() {
        return msg;
    }
}
