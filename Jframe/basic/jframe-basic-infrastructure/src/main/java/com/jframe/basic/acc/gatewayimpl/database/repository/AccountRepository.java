package com.jframe.basic.acc.gatewayimpl.database.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jframe.basic.acc.convertor.AccountMapStruct;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.AccountDbo;
import com.jframe.basic.acc.gatewayimpl.database.mapper.AccountMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/7 23:14
 * @Description: TODO 描述
 */
@Repository
public class AccountRepository extends ServiceImpl<AccountMapper, AccountDbo> {

    //    @Resource
//    private AccountMapper accountMapper;
    @Resource
    private AccountMapStruct accountMapStruct;

    public void createAccount(Account account) {
        AccountDbo dbo = accountMapStruct.toDbo(account);
        this.save(dbo);
        account.setId(dbo.getId());
    }

    public AccountDbo testGet(Long id) {
        return this.lambdaQuery()
                .eq(AccountDbo::getId, id)
                .one();
    }


    public AccountDbo getByPhone(String phone){
        return this.lambdaQuery()
                .eq(AccountDbo::getPhone,phone)
                .one();
    }

}
