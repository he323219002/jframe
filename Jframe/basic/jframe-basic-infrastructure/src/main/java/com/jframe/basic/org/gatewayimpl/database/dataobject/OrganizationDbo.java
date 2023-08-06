package com.jframe.basic.org.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.jframe.base.Dbo;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;


/**
 * <p>
 * 组织表
 * </p>
 *
 * @author jimmy
 * @since 2023-07-09
 */
@EqualsAndHashCode(callSuper = false)
@TableName("org_organization")
@Getter
public class OrganizationDbo extends Dbo {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    /**
     * 组织名称
     */
    @TableField("name")
    private String name;

    /**
     * 上级id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 组织级别
     */
    @TableField("level")
    private Integer level;

    /**
     * 租户id
     */
    @TableField("tenant_id")
    private Long tenantId;

    /**
     * 版本号
     */
    @TableField("version")
    @Version
    private Integer version;

    /**
     * 逻辑删除
     */
    @TableField("deleted")
    @TableLogic
    private Byte deleted;

    /**
     * 创建人id
     */
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    private Long updateUserId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
