package com.jframe.basic.per.gatewayimpl.database.repository;

import com.jframe.basic.per.gatewayimpl.database.dataobject.PermissionDbo;
import com.jframe.basic.per.gatewayimpl.database.mapper.PermissionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
* @author jimmy
* @since 2023-07-09
*/
@Repository
public class PermissionRepository extends ServiceImpl<PermissionMapper, PermissionDbo> {

}
