package com.jframe.basic.acc.command;

import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import com.jframe.basic.acc.domain.gateway.BusinessAccountGateway;
import com.jframe.basic.acc.dto.cmd.BusinessAccountLoginCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/14 21:54
 * @Description: TODO 描述
 */
@Component
public class BusinessAccountLoginCmdExe {

    @Resource
    private BusinessAccountGateway businessAccountGateway;


    public BusinessAccount execute(BusinessAccountLoginCmd cmd) {
        return businessAccountGateway.login(cmd.getUsername(), cmd.getPassword(), BusinessAccountTypeEnum.valueOf(cmd.getUsername()));
    }
}
