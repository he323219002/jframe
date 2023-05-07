package com.jframe.basic.acc.convertor;

import org.mapstruct.Mapper;
import com.jframe.basic.acc.dto.data.ThirdPartyAccountDto;
import com.jframe.basic.acc.domain.entity.ThirdPartyAccount;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.ThirdPartyAccountDbo;

/**
* @author jimmy
* @since 2023-05-05
*/
@Mapper(componentModel = "spring")
public interface ThirdPartyAccountMapStruct {

    ThirdPartyAccount toEntity(ThirdPartyAccountDto dto);

    ThirdPartyAccountDbo toDbo(ThirdPartyAccount entity);
}
