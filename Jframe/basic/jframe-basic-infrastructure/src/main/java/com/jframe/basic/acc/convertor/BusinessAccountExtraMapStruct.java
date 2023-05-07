package com.jframe.basic.acc.convertor;

import org.mapstruct.Mapper;
import com.jframe.basic.acc.dto.data.BusinessAccountExtraDto;
import com.jframe.basic.acc.domain.entity.BusinessAccountExtra;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.BusinessAccountExtraDbo;

/**
* @author jimmy
* @since 2023-05-05
*/
@Mapper(componentModel = "spring")
public interface BusinessAccountExtraMapStruct {

    BusinessAccountExtra toEntity(BusinessAccountExtraDto dto);

    BusinessAccountExtraDbo toDbo(BusinessAccountExtra entity);
}
