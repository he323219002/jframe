package com.jframe.basic.per.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.jframe.base.Dbo;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;


/**
* <p>
    * 
    * </p>
*
* @author jimmy
* @since 2023-07-09
*/
@EqualsAndHashCode(callSuper = false)
@TableName("per_permission")
public class PermissionDbo extends Dbo {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    /**
    * 描述
    */
    @TableField("description")
    private String description;

    @TableField("value")
    private String value;

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
    private Boolean deleted;

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
