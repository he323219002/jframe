package com.jframe.basic.org.domain.gateway;

import com.jframe.basic.org.dto.data.OrganizationDto;

/**
 * @author jimmy
 * @since 2023-07-09
 */
public interface OrganizationGateway {

    /**
     * 根据组织id获取
     *
     * @param id 组织id
     * @return
     */
    OrganizationDto getById(Long id);

    /**
     * 根据组织id获取
     *
     * @param id       组织id
     * @param tenantId 租户id
     * @return
     */
    OrganizationDto getById(Long id, Long tenantId);
}
