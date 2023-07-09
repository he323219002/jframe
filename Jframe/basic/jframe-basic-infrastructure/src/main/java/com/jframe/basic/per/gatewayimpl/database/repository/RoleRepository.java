package com.jframe.basic.per.gatewayimpl.database.repository;

import com.jframe.basic.per.gatewayimpl.database.dataobject.RoleDbo;
import com.jframe.basic.per.gatewayimpl.database.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
* @author jimmy
* @since 2023-07-09
*/
@Repository
public class RoleRepository extends ServiceImpl<RoleMapper, RoleDbo> {

}
