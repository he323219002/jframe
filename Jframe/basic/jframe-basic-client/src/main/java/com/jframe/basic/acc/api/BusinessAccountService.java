package com.jframe.basic.acc.api;


import com.jframe.basic.acc.dto.cmd.BusinessAccountCreateCmd;
import com.jframe.basic.acc.dto.cmd.BusinessAccountLoginCmd;

/**
 * <p>
 * 业务账号 服务类
 * </p>
 *
 * @author jimmy
 * @since 2024-01-21
 */
public interface BusinessAccountService {


    /**
     * 常见
     * @param cmd
     */
    void create(BusinessAccountCreateCmd cmd);

    /**
     * 登录
     *
     * @param cmd
     */
    void login(BusinessAccountLoginCmd cmd);
}
