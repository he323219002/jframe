package com.jframe.basic.acc.gatewayimpl.database.dataobject;

import com.jframe.base.Dbo;

import com.jframe.basic.domain.acc.enumerate.AccountStatusEnum;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/3 22:58
 * @Description: 主账号
 */
@ToString
public class AccountDO extends Dbo implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号（加密后）
     */
    private String idNumberCrypt;

    /**
     * 生日
     */
    private LocalDateTime birthDay;

    /**
     * 账号状态
     */
    private AccountStatusEnum status;
}
