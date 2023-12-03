package com.jframe.basic.org.service;

import com.jframe.basic.org.api.OrganizationService;
import com.jframe.basic.org.domain.gateway.OrganizationGateway;
import com.jframe.basic.org.dto.data.OrganizationDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 组织表 服务实现类
 * </p>
 *
 * @author jimmy
 * @since 2023-07-09
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationGateway organizationGateway;

    @Override
    public OrganizationDto getById(Long orgId) {
        // todo 从当前线程获取用户信息进行校验

        return null;
    }
}
