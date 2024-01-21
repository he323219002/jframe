package com.jframe.basic.acc.gatewayimpl.database.dataobject;

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
import com.jframe.basic.acc.domain.enumerate.*;


/**
* <p>
    * 业务账号
    * </p>
*
* @author jimmy
* @since 2023-05-05
*/
@EqualsAndHashCode(callSuper = false)
@TableName("acc_business_account")
@Data
public class BusinessAccountDbo extends Dbo {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @TableId("id")
    private Long id;

    /**
    * 账号id
    */
    @TableField("account_id")
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
    @TableField("phone")
    private String phone;

    /**
    * 用户名
    */
    @TableField("username")
    private String username;

    /**
    * 密码
    */
    @TableField("password")
    private String password;

    /**
    * 租户id
    */
    @TableField("tenant_id")
    private Long tenantId;

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

}
