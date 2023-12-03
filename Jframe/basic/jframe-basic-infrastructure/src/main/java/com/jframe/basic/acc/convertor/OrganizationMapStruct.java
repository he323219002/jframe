package com.jframe.basic.acc.convertor;

import com.jframe.basic.org.domain.entity.Organization;
import com.jframe.basic.org.dto.data.OrganizationDto;
import com.jframe.basic.org.gatewayimpl.database.dataobject.OrganizationDbo;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author jimmy
 * @since 2023-07-09
 */
@Mapper(componentModel = "spring")
public interface OrganizationMapStruct {

    Organization toEntity(OrganizationDto dto);

    Organization toEntity(OrganizationDbo dbo);

    OrganizationDbo toDbo(Organization entity);


}
