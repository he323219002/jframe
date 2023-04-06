package com.jframe.basic.domain.acc.enumerate;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/6 21:32
 * @Description: TODO 描述
 */

public enum AccountStatusEnum implements IEnum<Integer> {
    /**
     * 正常
     */
    NORMAL(0,"正常"),

    /**
     * 限制
     */
    LIMIT(1,"限制"),

    /**
     * 禁止
     */
    FORBIDDEN(-1,"禁止")
    ;

    private final Integer value;
    private final String desc;

    AccountStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
