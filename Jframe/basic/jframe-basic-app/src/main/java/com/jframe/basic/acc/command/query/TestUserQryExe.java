package com.jframe.basic.acc.command.query;

import com.jframe.basic.acc.convertor.AccountMapStruct;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.exception.AccountException;
import com.jframe.basic.acc.domain.gateway.AccountGateway;
import com.jframe.basic.acc.dto.AccountTestQry;
import com.jframe.exception.BusinessException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/14 21:54
 * @Description: TODO 描述
 */
@Component
public class TestUserQryExe {

    @Resource
    private AccountGateway accountGateway;


    public String execute(AccountTestQry qry) {
        Account account = accountGateway.testUser(qry.getId());
        return account.getName();
    }
}
