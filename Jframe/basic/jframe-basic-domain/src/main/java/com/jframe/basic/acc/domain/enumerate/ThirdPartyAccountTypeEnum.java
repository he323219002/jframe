package com.jframe.basic.acc.domain.enumerate;

import com.baomidou.mybatisplus.annotation.IEnum;





/**
* @author jimmy
* @since 2023-05-05
*/
public enum ThirdPartyAccountTypeEnum implements IEnum<Integer>{
    WECHAT(10,"微信"),
    ALIPAY(20,"支付宝"),
    ;

    private final Integer code;
    private final String message;

    ThirdPartyAccountTypeEnum(Integer code, String message) {
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
