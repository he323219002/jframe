package com.jframe.basic.acc.gatewayimpl;

import com.jframe.basic.acc.convertor.AccountMapStruct;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.gateway.AccountGateway;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.AccountDbo;
import com.jframe.basic.acc.gatewayimpl.database.repository.AccountRepository;
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

    @Override
    public Account testUser(Long id) {
        return accountMapStruct.toEntity(accountRepository.testGet(id));
    }

    @Override
    public void testCreateAdmin(Account account) {
    }
}