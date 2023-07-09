package com.jframe.basic.org.gatewayimpl.database.repository;

import com.jframe.basic.org.gatewayimpl.database.dataobject.PositionDbo;
import com.jframe.basic.org.gatewayimpl.database.mapper.PositionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
* @author jimmy
* @since 2023-07-09
*/
@Repository
public class PositionRepository extends ServiceImpl<PositionMapper, PositionDbo> {

}
