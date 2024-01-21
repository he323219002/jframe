package com.jframe.basic.acc.dto.data;

import com.jframe.base.Dto;

import java.io.Serial;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
 *
 * @author jimmy
 * @since 2023-04-27
 *  AccountDboDto类
 */
@EqualsAndHashCode(callSuper = false)
@Getter
public class AccountDto extends Dto {
    @Serial
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
    private Integer status;

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
