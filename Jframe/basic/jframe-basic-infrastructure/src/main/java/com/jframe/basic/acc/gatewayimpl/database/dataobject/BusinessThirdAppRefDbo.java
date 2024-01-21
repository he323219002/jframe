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


/**
* <p>
    * 业务-三方关联表
    * </p>
*
* @author jimmy
* @since 2023-05-05
*/
@EqualsAndHashCode(callSuper = false)
@TableName("acc_business_third_app_ref")
public class BusinessThirdAppRefDbo extends Dbo {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @TableId("id")
    private Long id;

    /**
    * 业务账号id
    */
    @TableField("business_account_id")
    private Long businessAccountId;

    /**
    * 三方账号id
    */
    @TableField("third_party_account_id")
    private Long thirdPartyAccountId;

    /**
    * 业务类型
    */
    @TableField("business_type")
    private Integer businessType;

    /**
    * 三方账号类型
    */
    @TableField("third_type")
    private Integer thirdType;

    /**
    * 应用账号
    */
    @TableField("app_account")
    private String appAccount;

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
