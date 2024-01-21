package com.jframe.basic.acc.dto.cmd;

import com.jframe.base.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @Author: Jimmy He
 * @Date: 2023/7/23 17:27
 * @Description: TODO 描述
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessAccountLoginCmd extends Command {

    /**
     * 用戶名
     */
    @NotNull(message = "用户名必填")
    private String username;

    /**
     * 密碼
     */
    @NotNull(message = "密码必填")
    private String password;


    /**
     * 业务类型
     */
    @NotNull(message = "业务类型必填")
    private String businessType;

}
