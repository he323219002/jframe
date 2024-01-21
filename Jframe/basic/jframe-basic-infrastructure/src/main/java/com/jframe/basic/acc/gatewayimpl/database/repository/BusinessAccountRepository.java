package com.jframe.basic.acc.gatewayimpl.database.repository;

import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.BusinessAccountDbo;
import com.jframe.basic.acc.gatewayimpl.database.mapper.BusinessAccountMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author jimmy
 * @since 2024-01-21
 */
@Repository
public class BusinessAccountRepository extends ServiceImpl<BusinessAccountMapper, BusinessAccountDbo> {

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
}
