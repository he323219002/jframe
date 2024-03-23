package com.jframe.basic.acc.convertor;

import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.domain.param.BusinessAccountCreateParam;
import com.jframe.basic.acc.dto.cmd.BusinessAccountCreateCmd;
import org.mapstruct.Mapper;
import com.jframe.basic.acc.dto.data.BusinessAccountDto;
import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.BusinessAccountDbo;
import org.mapstruct.Mapping;

/**
* @author jimmy
* @since 2023-05-05
*/
@Mapper(componentModel = "spring")
public interface BusinessAccountMapStruct {

    @Mapping(target = "type",ignore = true)
    @Mapping(target = "status",ignore = true)
    BusinessAccount toEntity(BusinessAccountDto dto);

    @Mapping(target = "type",expression = "java(com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum.valueOf(cmd.getBizType()))")
    BusinessAccount toEntity(BusinessAccountCreateCmd cmd);

    BusinessAccountDbo toDbo(BusinessAccount entity);

    BusinessAccount toEntity(BusinessAccountDbo dbo);

    BusinessAccountDbo toDbo(BusinessAccountCreateParam param);

    Account toAccountEntity(BusinessAccountCreateCmd cmd);
}
