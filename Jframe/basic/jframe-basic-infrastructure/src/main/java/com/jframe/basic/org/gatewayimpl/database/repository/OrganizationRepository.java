package com.jframe.basic.org.gatewayimpl.database.repository;

import com.jframe.basic.org.gatewayimpl.database.dataobject.OrganizationDbo;
import com.jframe.basic.org.gatewayimpl.database.mapper.OrganizationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
* @author jimmy
* @since 2023-07-09
*/
@Repository
public class OrganizationRepository extends ServiceImpl<OrganizationMapper, OrganizationDbo> {

}
