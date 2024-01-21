package com.jframe.basic.acc.service;

import com.jframe.basic.acc.command.BusinessAccountLoginCmdExe;
import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.domain.gateway.BusinessAccountGateway;
import com.jframe.basic.acc.dto.cmd.BusinessAccountLoginCmd;
import com.jframe.basic.acc.api.BusinessAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 业务账号 服务实现类
 * </p>
 *
 * @author jimmy
 * @since 2024-01-21
 */
@Service
public class BusinessAccountServiceImpl implements BusinessAccountService {

    @Resource
    private BusinessAccountGateway businessAccountGateway;
    @Resource
    private BusinessAccountLoginCmdExe businessAccountLoginCmdExe;

    @Override
    public void login(BusinessAccountLoginCmd cmd) {
        BusinessAccount businessAccount = businessAccountLoginCmdExe.execute(cmd);
        // todo 组装用户信息进缓存
    }
}
