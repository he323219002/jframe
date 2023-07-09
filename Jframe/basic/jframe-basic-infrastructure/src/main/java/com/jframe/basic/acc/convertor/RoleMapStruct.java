package com.jframe.basic.acc.convertor;

import com.jframe.basic.per.gatewayimpl.database.dataobject.RoleDbo;
import org.mapstruct.Mapper;
import com.jframe.basic.per.dto.data.RoleDto;
import com.jframe.basic.per.domain.entity.Role;

/**
* @author jimmy
* @since 2023-07-09
*/
@Mapper(componentModel = "spring")
public interface RoleMapStruct {

    Role toEntity(RoleDto dto);

    RoleDbo toDbo(Role entity);
}
