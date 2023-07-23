package com.jframe.basic.per.domain.entity;
import com.jframe.base.Entity;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;


/**
* @author jimmy
* @since 2023-07-09
* Permission领域模型
*/


@EqualsAndHashCode(callSuper = false)
public class Permission extends Entity{


    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    private Long id;

    /**
    * 描述
    */
    private String description;

    /**
    * 
    */
    private String value;

    /**
    * 租户id
    */
    private Long tenantId;

    /**
    * 版本号
    */
    private Integer version;

    /**
    * 逻辑删除
    */
    private Byte deleted;

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

}