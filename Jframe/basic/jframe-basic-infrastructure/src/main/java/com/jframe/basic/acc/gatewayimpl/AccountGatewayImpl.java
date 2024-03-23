package com.jframe.basic.acc.gatewayimpl;

import com.jframe.basic.acc.convertor.AccountMapStruct;
import com.jframe.basic.acc.domain.constant.AccConstant;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.enumerate.AccountStatusEnum;
import com.jframe.basic.acc.domain.exception.AccountException;
import com.jframe.basic.acc.domain.gateway.AccountGateway;
import com.jframe.basic.acc.gatewayimpl.database.repository.AccountRepository;
import com.jframe.exception.BusinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

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
        accountRepository.createAccount(account);
    }


    @Override
    public Account getByPhone(String phone) {
        return accountMapStruct.toEntity(accountRepository.getByPhone(phone));
    }

    @Override
    public Account getByUsername(String username) {
        // todo
        return null;
    }

    @Override
    public void create(Account account) {
        // todo 待修改从线程里获取用户信息
        account.setCreateUserId(AccConstant.SYSTEM_ID);
        account.setUpdateUserId(AccConstant.SYSTEM_ID);
        account.setStatus(AccountStatusEnum.NORMAL);
        accountRepository.createAccount(account);
    }
}
