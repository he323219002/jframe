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
*  ThirdPartyAccountDboDto类
*/
@EqualsAndHashCode(callSuper = false)
@Getter
public class ThirdPartyAccountDto extends Dto {
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
    * enum=10:WECHAT:微信;20:ALIPAY:支付宝;
    */
    private Integer type;

    /**
    * 三方账号
    */
    private String thirdPartyAccount;

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

    /**
    * 版本号
    */
    private Integer version;

    /**
    * 逻辑删除
    */
    private Boolean deleted;

}
