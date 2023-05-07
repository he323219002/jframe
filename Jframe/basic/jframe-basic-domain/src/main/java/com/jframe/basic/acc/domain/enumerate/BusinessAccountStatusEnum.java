package com.jframe.basic.acc.domain.enumerate;

import com.baomidou.mybatisplus.annotation.IEnum;





/**
* @author jimmy
* @since 2023-05-05
*/
public enum BusinessAccountStatusEnum implements IEnum<Integer>{
    NORMAL(10,"正常"),
    BANNED(20,"停用"),
    ;

    private final Integer code;
    private final String message;

    BusinessAccountStatusEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
    }

    public Integer code() {
    return this.code;
    }

    public String message() {
    return this.message;
    }


    @Override
    public Integer getValue() {
    return this.code;
    }
}
