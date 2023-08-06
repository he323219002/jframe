package com.jframe.basic.org.gatewayimpl;

import com.jframe.basic.acc.domain.constant.AccConstant;
import com.jframe.basic.org.domain.gateway.OrganizationGateway;
import com.jframe.basic.org.dto.data.OrganizationDto;
import com.jframe.basic.org.gatewayimpl.database.repository.OrganizationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jimmy
 * @since 2023-07-09
 */
@Component
public class OrganizationGatewayImpl implements OrganizationGateway {

    @Resource
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto getById(Long id) {
        // todo 从用户线程中获取租户id
        Long tenantId = null;
        if (AccConstant.SYSTEM_ID.equals(tenantId)) {
            organizationRepository.getById(id);
        }

        return null;
    }

    @Override
    public OrganizationDto getById(Long id, Long tenantId) {
        return null;
    }
}
