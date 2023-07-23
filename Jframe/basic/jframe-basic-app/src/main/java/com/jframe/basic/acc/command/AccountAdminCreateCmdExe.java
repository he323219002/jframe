package com.jframe.basic.acc.command;

import com.jframe.basic.acc.convertor.AccountMapStruct;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.gateway.AccountGateway;
import com.jframe.basic.acc.dto.AccountTestQry;
import com.jframe.basic.acc.dto.cmd.AccountAdminCreateCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/14 21:54
 * @Description: TODO 描述
 */
@Component
public class AccountAdminCreateCmdExe {

    @Resource
    private AccountGateway accountGateway;
    @Resource
    private AccountMapStruct accountMapStruct;


    public void execute(AccountAdminCreateCmd cmd) {
        Account account = Account.adminAccount(cmd.getUsername(), cmd.getPassword());
        accountGateway.createAdmin(account);
    }
}
