package com.jframe.basic.acc.domain.entity;
import com.jframe.base.Entity;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import com.jframe.basic.acc.domain.enumerate.*;


/**
* @author jimmy
* @since 2023-05-05
* ThirdPartyAccount领域模型
*/


@EqualsAndHashCode(callSuper = false)
public class ThirdPartyAccount extends Entity{


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
    private ThirdPartyAccountTypeEnum type;

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
