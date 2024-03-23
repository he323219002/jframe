package com.jframe.basic.acc.gatewayimpl;

import com.jframe.basic.acc.convertor.AccountMapStruct;
import com.jframe.basic.acc.convertor.BusinessAccountMapStruct;
import com.jframe.basic.acc.domain.constant.AccConstant;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountStatusEnum;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import com.jframe.basic.acc.domain.exception.AccountException;
import com.jframe.basic.acc.domain.gateway.AccountGateway;
import com.jframe.basic.acc.domain.gateway.BusinessAccountGateway;
import com.jframe.basic.acc.domain.param.BusinessAccountCreateParam;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.BusinessAccountDbo;
import com.jframe.basic.acc.gatewayimpl.database.repository.AccountRepository;
import com.jframe.basic.acc.gatewayimpl.database.repository.BusinessAccountRepository;
import com.jframe.exception.BusinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author jimmy
 * @since 2023-04-28
 */
@Component
public class BusinessAccountGatewayImpl implements BusinessAccountGateway {

    @Resource
    private BusinessAccountRepository businessAccountRepository;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private BusinessAccountMapStruct businessAccountMapStruct;

    @Override
    public BusinessAccount login(String username, String password, BusinessAccountTypeEnum type) {
        Optional<BusinessAccountDbo> businessAccountOpt = businessAccountRepository.getByUsernameAndPwdAndBizType(
                username, passwordEncoder.encode(password), type
        );

        if (businessAccountOpt.isEmpty()) {
            throw BusinessException.of(AccountException.LOGIN_FAILURE);
        }
        return businessAccountMapStruct.toEntity(businessAccountOpt.get());
    }

    @Override
    public void create(BusinessAccount account) {
        account.setStatus(BusinessAccountStatusEnum.NORMAL);
        account.setCreateUserId(AccConstant.SYSTEM_ID);
        account.setUpdateUserId(AccConstant.SYSTEM_ID);
        businessAccountRepository.create(account);
    }

    @Override
    public BusinessAccount getByPhoneAndBizType(String phone, BusinessAccountTypeEnum bizType) {
        return businessAccountMapStruct.toEntity(
                businessAccountRepository.getByPhoneAndBizType(phone, bizType)
        );
    }
}
