package com.jframe.basic.acc.gatewayimpl.database.repository;

import com.jframe.basic.acc.convertor.BusinessAccountMapStruct;
import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import com.jframe.basic.acc.domain.exception.AccountException;
import com.jframe.basic.acc.domain.param.BusinessAccountCreateParam;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.BusinessAccountDbo;
import com.jframe.basic.acc.gatewayimpl.database.mapper.BusinessAccountMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jframe.exception.BusinessException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author jimmy
 * @since 2024-01-21
 */
@Repository
public class BusinessAccountRepository extends ServiceImpl<BusinessAccountMapper, BusinessAccountDbo> {

    @Resource
    private BusinessAccountMapStruct businessAccountMapStruct;

    /**
     * 三要素条件查询
     *
     * @param username 用户名
     * @param pwd      密码
     * @param bizType  业务类型
     * @return
     */
    public Optional<BusinessAccountDbo> getByUsernameAndPwdAndBizType(String username, String pwd, BusinessAccountTypeEnum bizType) {
        return this.lambdaQuery()
                .eq(BusinessAccountDbo::getUsername, username)
                .eq(BusinessAccountDbo::getPassword, pwd)
                .eq(BusinessAccountDbo::getType, bizType)
                .oneOpt();
    }


    public BusinessAccountDbo getByPhoneAndBizType(String phone,BusinessAccountTypeEnum bizType){
        return this.lambdaQuery()
                .eq(BusinessAccountDbo::getPhone,phone)
                .eq(BusinessAccountDbo::getType,bizType)
                .one();
    }


    public void create(BusinessAccount businessAccount) {

        BusinessAccountDbo dbo = businessAccountMapStruct.toDbo(businessAccount);
        this.save(dbo);

    }
}
