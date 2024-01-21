package com.jframe.basic.acc.domain.entity;
import com.jframe.base.Entity;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;


/**
* @author jimmy
* @since 2023-05-05
* BusinessThirdAppRef领域模型
*/


@EqualsAndHashCode(callSuper = false)
public class BusinessThirdAppRef extends Entity{


    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * 业务账号id
    */
    private Long businessAccountId;

    /**
    * 三方账号id
    */
    private Long thirdPartyAccountId;

    /**
    * 业务类型
    */
    private Integer businessType;

    /**
    * 三方账号类型
    */
    private Integer thirdType;

    /**
    * 应用账号
    */
    private String appAccount;

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
