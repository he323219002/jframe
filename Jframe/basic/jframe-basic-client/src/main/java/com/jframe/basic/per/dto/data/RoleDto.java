package com.jframe.basic.per.dto.data;

import com.jframe.base.Dto;

import java.io.Serial;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
*
* @author jimmy
* @since 2023-07-09
*  RoleDboDto类
*/
@EqualsAndHashCode(callSuper = false)
@Getter
public class RoleDto extends Dto {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    private Long id;

    /**
    * 角色名称
    */
    private String name;

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
