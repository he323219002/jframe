package com.jframe.basic.acc.domain.gateway;

import com.jframe.basic.acc.domain.entity.Account;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/3 23:09
 * @Description: 账号gateway
 */
public interface AccountGateway {

    Account testUser(Long  id);

    /**
     * 测试创建管理员
     * @param account
     */
    void testCreateAdmin(Account account);
}
