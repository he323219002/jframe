package com.jframe.basic.acc.domain.entity;
import com.jframe.base.Entity;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import com.jframe.basic.acc.domain.enumerate.*;


/**
* @author jimmy
* @since 2023-05-05
* BusinessAccount领域模型
*/


@EqualsAndHashCode(callSuper = false)
public class BusinessAccount extends Entity{


    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * 账号id
    */
    private Long accountId;

    /**
    * enum=10:NORMAL:正常;20:BANNED:停用;
    */
    private BusinessAccountStatusEnum status;

    /**
    * enum=10:OPERATION_PLATFORM:运营后台;20:SUPPLY_CHAIN:供应链;
    */
    private BusinessAccountTypeEnum type;

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
     * 登录token
     */
    private String token;


    /**
    * 租户id
    */
    private Long tenantId;

    /**
    * 创建人id
    */
    private Long createUserId;

    /**
    * 创建时间
    */
    private LocalDateTime createTime;

    /**
    * 更新人id
    */
    private Long updateUserId;

    /**
    * 更新时间
    */
    private LocalDateTime updateTime;

    /**
    * 版本号
    */
    private Integer version;

    /**
    * 逻辑删除
    */
    private Boolean deleted;

}
