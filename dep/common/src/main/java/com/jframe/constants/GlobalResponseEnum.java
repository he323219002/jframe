package com.jframe.constants;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/28 23:17
 * @Description: TODO 描述
 */
public enum GlobalResponseEnum {
    SUCCESS("200", "操作成功"),
    UNAUTHORIZED("401", "未认证通过"),
    FORBIDDEN("403", "没有权限"),

    EXCEPTION("500", "系统异常"),
    ;

    private String code;

    private String message;

    GlobalResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
