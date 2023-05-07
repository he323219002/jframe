package com.jframe.basic.acc.domain.enumerate;

import com.baomidou.mybatisplus.annotation.IEnum;





/**
* @author jimmy
* @since 2023-05-05
*/
public enum BusinessAccountTypeEnum implements IEnum<Integer>{
    OPERATION_PLATFORM(10,"运营后台"),
    SUPPLY_CHAIN(20,"供应链"),
    ;

    private final Integer code;
    private final String message;

    BusinessAccountTypeEnum(Integer code, String message) {
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
