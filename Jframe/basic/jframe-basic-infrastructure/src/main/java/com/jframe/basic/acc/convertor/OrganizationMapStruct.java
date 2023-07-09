package com.jframe.basic.acc.convertor;

import org.mapstruct.Mapper;
import com.jframe.basic.org.dto.data.OrganizationDto;
import com.jframe.basic.org.domain.entity.Organization;
import com.jframe.basic.org.gatewayimpl.database.dataobject.OrganizationDbo;

/**
* @author jimmy
* @since 2023-07-09
*/
@Mapper(componentModel = "spring")
public interface OrganizationMapStruct {

    Organization toEntity(OrganizationDto dto);

    OrganizationDbo toDbo(Organization entity);
}
