package com.jframe.basic.acc.domain.gateway;

import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;

import java.util.Optional;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/3 23:09
 * @Description: 账号gateway
 */
public interface AccountGateway {

    Account testUser(Long id);

    /**
     * 测试创建管理员
     *
     * @param account
     */
    void createAdmin(Account account);


    /**
     * 通过手机号获取
     *
     * @param phone
     * @return
     */
    Account getByPhone(String phone);

    /**
     * 通过用户名获取
     * @param username
     * @return
     */
    Account getByUsername(String username);

    /**
     * 创建账号
     *
     * @param account
     */
    void create(Account account);
}
