package com.jframe.basic.acc.domain.gateway;

import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;

/**
 * @Author: Jimmy He
 * @Date: 2024/1/21 18:11
 * @Description: 业务账号gateway
 */
public interface BusinessAccountGateway {

    /**
     * 登录
     *
     * @return Account
     */
    BusinessAccount login(String username, String password, BusinessAccountTypeEnum type);

}
