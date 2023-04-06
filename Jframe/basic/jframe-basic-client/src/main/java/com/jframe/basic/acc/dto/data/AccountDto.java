package com.jframe.basic.acc.dto.data;

import com.jframe.base.Dto;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/5 19:06
 * @Description: 账号dto类
 */
public class AccountDto extends Dto {

    @Serial
    private static final long serialVersionUID = -7240373171020998829L;

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
    private Integer status;
}
