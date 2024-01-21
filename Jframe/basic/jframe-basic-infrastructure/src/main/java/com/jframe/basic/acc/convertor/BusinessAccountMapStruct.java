package com.jframe.basic.acc.convertor;

import org.mapstruct.Mapper;
import com.jframe.basic.acc.dto.data.BusinessAccountDto;
import com.jframe.basic.acc.domain.entity.BusinessAccount;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.BusinessAccountDbo;

/**
* @author jimmy
* @since 2023-05-05
*/
@Mapper(componentModel = "spring")
public interface BusinessAccountMapStruct {

    BusinessAccount toEntity(BusinessAccountDto dto);

    BusinessAccountDbo toDbo(BusinessAccount entity);

    BusinessAccount toEntity(BusinessAccountDbo dbo);
}
