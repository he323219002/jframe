package com.jframe.basic.acc.service;

import com.jframe.basic.acc.api.AccountService;
import com.jframe.basic.acc.command.AccountAdminCreateCmdExe;
import com.jframe.basic.acc.command.query.TestUserQryExe;
import com.jframe.basic.acc.dto.AccountTestQry;
import com.jframe.basic.acc.dto.cmd.AccountAdminCreateCmd;
import com.jframe.basic.org.api.OrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 账号 服务实现类
 * </p>
 *
 * @author jimmy
 * @since 2023-04-27
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private TestUserQryExe testUserQryExe;
    @Resource
    private AccountAdminCreateCmdExe accountAdminCreateCmdExe;
    @Resource
    private OrganizationService organizationService;

    @Override
    public String testGet(AccountTestQry qry) {
        return testUserQryExe.execute(qry);
    }

    @Override
    public void createAdmin(AccountAdminCreateCmd cmd) {
        // 校验租户
        Long tenantId = cmd.getTenantId();
        accountAdminCreateCmdExe.execute(cmd);
    }


    // 校验租户id
    private void checkTenantId(Long tenantId) {

    }
}
