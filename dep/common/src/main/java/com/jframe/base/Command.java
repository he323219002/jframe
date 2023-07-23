package com.jframe.base;

import lombok.Getter;

import java.io.Serial;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/11 22:40
 * @Description: Command类
 */
@Getter
public abstract class Command extends Dto {

    @Serial
    private static final long serialVersionUID = -1L;

    /**
     * 操作人id
     */
    private Long operatorId;

    /**
     * 操作人名称
     */
    private Long operatorName;
}
