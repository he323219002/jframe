package com.jframe.basic.acc.domain.entity;
import com.jframe.base.Entity;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import com.jframe.basic.acc.domain.enumerate.*;


/**
 * @author jimmy
 * @since 2023-04-27
 * Account领域模型
 */


@EqualsAndHashCode(callSuper = false)
public class Account extends Entity{


    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证信息（加密）
     */
    private String idNumberCrypt;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * enum=10:NORMAL:正常;20:BANNED:停用;
     */
    private AccountStatusEnum status;

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
     * 创建人姓名
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
