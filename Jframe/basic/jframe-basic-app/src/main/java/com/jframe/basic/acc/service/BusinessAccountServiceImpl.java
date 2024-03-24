package com.jframe.basic.acc.service;

import com.jframe.basic.acc.command.BusinessAccountLoginCmdExe;
import com.jframe.basic.acc.convertor.BusinessAccountMapStruct;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import com.jframe.basic.acc.domain.exception.AccountException;
import com.jframe.basic.acc.domain.gateway.AccountGateway;
import com.jframe.basic.acc.domain.gateway.BusinessAccountGateway;
import com.jframe.basic.acc.dto.cmd.BusinessAccountCreateCmd;
import com.jframe.basic.acc.dto.cmd.BusinessAccountLoginCmd;
import com.jframe.basic.acc.api.BusinessAccountService;
import com.jframe.exception.BusinessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

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
    @Resource
    private AccountGateway accountGateway;
    @Resource
    private BusinessAccountMapStruct businessAccountMapStruct;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public void login(BusinessAccountLoginCmd cmd) {
        BusinessAccount businessAccount = businessAccountLoginCmdExe.execute(cmd);
        // todo 组装用户信息进缓存

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(BusinessAccountCreateCmd cmd) {
        // 判断业务账号是否存在
        BusinessAccount businessAccountExist = businessAccountGateway.getByPhoneAndBizType(cmd.getPhone(), BusinessAccountTypeEnum.valueOf(cmd.getBizType()));
        if (Objects.nonNull(businessAccountExist)){
            throw BusinessException.of(AccountException.BIZ_ACC_PHONE_EXIST);
        }

        // 如果没有主账号则先创建主账号

        Account account = accountGateway.getByPhone(cmd.getPhone());
        if (Objects.isNull(account)){
            account = businessAccountMapStruct.toAccountEntity(cmd);
            accountGateway.create(account);
        }

        BusinessAccount businessAccount = businessAccountMapStruct.toEntity(cmd);
        businessAccount.setAccountId(account.getId());
        businessAccount.setTenantId(1L);
        businessAccountGateway.create(businessAccount);
    }
}
