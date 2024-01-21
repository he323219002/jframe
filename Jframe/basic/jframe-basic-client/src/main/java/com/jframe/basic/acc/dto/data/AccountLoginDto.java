package com.jframe.basic.acc.dto.data;

import com.jframe.base.Dto;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;

/**
 * @Author: Jimmy He
 * @Date: 2024/1/21 17:33
 * @Description: 用户登录成功返回
 */
@EqualsAndHashCode(callSuper = false)
@Getter
public class AccountLoginDto extends Dto {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * token
     */
    private String token;
}
