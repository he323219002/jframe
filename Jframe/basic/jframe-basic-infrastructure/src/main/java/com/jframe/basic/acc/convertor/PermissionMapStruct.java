package com.jframe.basic.acc.convertor;

import com.jframe.basic.per.gatewayimpl.database.dataobject.PermissionDbo;
import org.mapstruct.Mapper;
import com.jframe.basic.per.dto.data.PermissionDto;
import com.jframe.basic.per.domain.entity.Permission;

/**
* @author jimmy
* @since 2023-07-09
*/
@Mapper(componentModel = "spring")
public interface PermissionMapStruct {

    Permission toEntity(PermissionDto dto);

    PermissionDbo toDbo(Permission entity);
}
