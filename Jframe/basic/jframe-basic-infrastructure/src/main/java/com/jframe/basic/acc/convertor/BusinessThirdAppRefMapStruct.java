package com.jframe.basic.acc.convertor;

import org.mapstruct.Mapper;
import com.jframe.basic.acc.dto.data.BusinessThirdAppRefDto;
import com.jframe.basic.acc.domain.entity.BusinessThirdAppRef;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.BusinessThirdAppRefDbo;

/**
* @author jimmy
* @since 2023-05-05
*/
@Mapper(componentModel = "spring")
public interface BusinessThirdAppRefMapStruct {

    BusinessThirdAppRef toEntity(BusinessThirdAppRefDto dto);

    BusinessThirdAppRefDbo toDbo(BusinessThirdAppRef entity);
}
