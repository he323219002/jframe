package com.jframe.basic.acc.service;

import com.jframe.basic.acc.api.AccountService;
import com.jframe.basic.acc.command.query.TestUserQryExe;
import com.jframe.basic.acc.dto.AccountTestQry;
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

    @Override
    public String testGet(AccountTestQry qry) {
        return testUserQryExe.execute(qry);
    }
}
