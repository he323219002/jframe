package com.jframe.basic.acc.domain.gateway;

import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import com.jframe.basic.acc.domain.param.BusinessAccountCreateParam;
import com.jframe.basic.acc.dto.cmd.BusinessAccountCreateCmd;

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


    /**
     * 创建业务账号
     * @param account
     */
    void create(BusinessAccount account);

    /**
     * 根据手机号获取
     * @param phone
     * @return
     */
    BusinessAccount getByPhoneAndBizType(String phone,BusinessAccountTypeEnum bizType);
}
