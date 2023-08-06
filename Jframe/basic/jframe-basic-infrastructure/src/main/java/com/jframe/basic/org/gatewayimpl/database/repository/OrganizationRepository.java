package com.jframe.basic.org.gatewayimpl.database.repository;

import com.jframe.basic.acc.convertor.OrganizationMapStruct;
import com.jframe.basic.org.domain.entity.Organization;
import com.jframe.basic.org.domain.exception.OrgException;
import com.jframe.basic.org.gatewayimpl.database.dataobject.OrganizationDbo;
import com.jframe.basic.org.gatewayimpl.database.mapper.OrganizationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jframe.exception.BusinessException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author jimmy
 * @since 2023-07-09
 */
@Repository
public class OrganizationRepository extends ServiceImpl<OrganizationMapper, OrganizationDbo> {

    @Resource
    private OrganizationMapStruct organizationMapStruct;

    public Organization getById(Long id) {
        return organizationMapStruct.toEntity(this.lambdaQuery()
                .eq(OrganizationDbo::getId, id)
                .oneOpt()
                .orElseThrow(() -> BusinessException.of(OrgException.ORG_NOT_FOUND)));
    }
}
