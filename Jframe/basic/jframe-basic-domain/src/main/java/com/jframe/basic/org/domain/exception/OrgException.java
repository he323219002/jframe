package com.jframe.basic.org.domain.exception;

import com.jframe.exception.CommonError;

/**
 * @author Jimmy He
 * @date 2023/08/04
 * @description: todo 注释信息
 */
public enum OrgException implements CommonError {
    ORG_NOT_FOUND("O0001", "未找到相关组织信息"),
    ;


    private String code;

    private String msg;

    OrgException(String code, String msg) {
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
