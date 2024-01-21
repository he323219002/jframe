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
*  BusinessAccountExtraDboDto类
*/
@EqualsAndHashCode(callSuper = false)
@Getter
public class BusinessAccountExtraDto extends Dto {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * 业务账号id
    */
    private Long businessAccountId;

    /**
    * 省编码
    */
    private String provinceCode;

    /**
    * 省名称
    */
    private String province;

    /**
    * 市编码
    */
    private String cityCode;

    /**
    * 市名称
    */
    private String city;

    /**
    * 区编码
    */
    private String districtCode;

    /**
    * 区名称
    */
    private String district;

    /**
    * 头像
    */
    private String avatar;

    /**
    * 详细地址
    */
    private String addrDetail;

    /**
    * 签名
    */
    private String signature;

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
