package com.jframe.basic.acc.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import com.jframe.base.Dbo;

import com.jframe.basic.acc.domain.enumerate.AccountStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/3 22:58
 * @Description: 主账号
 */

@EqualsAndHashCode(callSuper = false)
@TableName(value = "acc_account")
@Data
public class AccountDbo extends Dbo {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 身份证信息（加密）
     */
    @TableField("id_number_crypt")
    private String idNumberCrypt;

    /**
     * 生日
     */
    @TableField("birthday")
    private LocalDateTime birthday;

    /**
     * enum=10:NORMAL:正常;20:BANNED:停用;
     */
    private AccountStatusEnum status;

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
     * 创建人姓名
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
