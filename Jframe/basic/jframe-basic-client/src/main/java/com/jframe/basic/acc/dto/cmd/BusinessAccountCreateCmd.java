package com.jframe.basic.acc.dto.cmd;

import com.jframe.base.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @Author: Jimmy He
 * @Date: 2024/3/23 15:13
 * @Description: TODO 描述
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class BusinessAccountCreateCmd extends Command {

    /**
     * 联系方式
     */
    @NotNull(message = "联系方式必填")
    private String phone;

    /**
     * 用户名
     */
    @NotNull(message = "用户名必填")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码必填")
    private String password;


    // ========== service 封装 ============
    /**
     * 业务类型
     */
    private String bizType;
}
