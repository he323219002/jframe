package com.jframe.basic.acc.gatewayimpl;

import com.jframe.basic.acc.convertor.AccountMapStruct;
import com.jframe.basic.acc.domain.constant.AccConstant;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import com.jframe.basic.acc.domain.exception.AccountException;
import com.jframe.basic.acc.domain.gateway.AccountGateway;
import com.jframe.basic.acc.gatewayimpl.database.repository.AccountRepository;
import com.jframe.exception.BusinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jimmy
 * @since 2023-04-28
 */
@Component
public class AccountGatewayImpl implements AccountGateway {

    @Resource
    private AccountRepository accountRepository;
    @Resource
    private AccountMapStruct accountMapStruct;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public Account testUser(Long id) {
        throw BusinessException.of(AccountException.TEST);
//        return accountMapStruct.toEntity(accountRepository.testGet(id));
    }

    @Override
    public void createAdmin(Account account) {
        account.setCreateUserId(AccConstant.SYSTEM_ID);
        account.setUpdateUserId(AccConstant.SYSTEM_ID);
        // 密码加密
        String rawPassword = account.getPassword();
        account.setPassword(passwordEncoder.encode(rawPassword));
        accountRepository.createAdminAccount(account);
    }


}
