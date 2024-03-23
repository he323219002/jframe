package com.jframe.basic.acc.domain.param;

import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: Jimmy He
 * @Date: 2024/3/23 15:28
 * @Description: TODO 描述
 */
@Data
public class BusinessAccountCreateParam {

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * enum=10:OPERATION_PLATFORM:运营后台;20:SUPPLY_CHAIN:供应链;
     */
    private BusinessAccountTypeEnum type;


    /**
     * 租户id
     */
    private Long tenantId;

}
