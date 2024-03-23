package com.jframe.basic.acc.dto.data;

import com.jframe.base.Dto;

import java.io.Serial;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
*
* @author jimmy
* @since 2023-05-05
*  BusinessAccountDboDto类
*/
@EqualsAndHashCode(callSuper = false)
@Getter
public class BusinessAccountDto extends Dto {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * 账号id
    */
    private Long accountId;

    /**
    * enum=10:NORMAL:正常;20:BANNED:停用;
    */
    private Integer status;

    /**
    * enum=10:OPERATION_PLATFORM:运营后台;20:SUPPLY_CHAIN:供应链;
    */
    private Integer type;

    /**
    * 联系方式
    */
    private String phone;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;


}
