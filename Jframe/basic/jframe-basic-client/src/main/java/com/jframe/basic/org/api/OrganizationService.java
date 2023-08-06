package com.jframe.basic.org.api;


import com.jframe.basic.org.dto.data.OrganizationDto;

/**
 * <p>
 * 组织表 服务类
 * </p>
 *
 * @author jimmy
 * @since 2023-07-09
 */
public interface OrganizationService {

    /**
     * 根据组织id获取信息
     * @param orgId 组织id
     * @return 组织信息DTO
     */
    OrganizationDto getById(Long orgId);
}
