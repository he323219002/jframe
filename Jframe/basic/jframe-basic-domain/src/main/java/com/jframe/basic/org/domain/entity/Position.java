package com.jframe.basic.org.domain.entity;
import com.jframe.base.Entity;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;


/**
* @author jimmy
* @since 2023-07-09
* Position领域模型
*/


@EqualsAndHashCode(callSuper = false)
public class Position extends Entity{


    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    private Long id;

    /**
    * 职位名称
    */
    private String name;

    /**
    * 所属组织id
    */
    private Long orgId;

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
    private Boolean deleted;

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
