package com.jframe.basic.acc.convertor;

import org.mapstruct.Mapper;
import com.jframe.basic.org.dto.data.PositionDto;
import com.jframe.basic.org.domain.entity.Position;
import com.jframe.basic.org.gatewayimpl.database.dataobject.PositionDbo;

/**
* @author jimmy
* @since 2023-07-09
*/
@Mapper(componentModel = "spring")
public interface PositionMapStruct {

    Position toEntity(PositionDto dto);

    PositionDbo toDbo(Position entity);
}
