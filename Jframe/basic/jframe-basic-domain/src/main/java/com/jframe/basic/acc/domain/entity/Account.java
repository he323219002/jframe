package com.jframe.basic.acc.domain.entity;

import com.jframe.base.Entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.jframe.basic.acc.domain.enumerate.*;
import lombok.Getter;
import lombok.Setter;


/**
 * @author jimmy
 * @since 2023-04-27
 * Account领域模型
 */


@EqualsAndHashCode(callSuper = false)
@Data
public class Account extends Entity {

    private static final long serialVersionUID = 1L;

    public Account() {
    }

    private Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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


    public static Account adminAccount(String username, String password) {
        Account account = new Account(username, password);
        account.status = AccountStatusEnum.NORMAL;
        return account;
    }

}
