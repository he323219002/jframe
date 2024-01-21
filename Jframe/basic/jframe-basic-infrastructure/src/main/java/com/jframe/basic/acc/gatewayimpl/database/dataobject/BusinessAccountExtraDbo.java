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
    * 账号拓展信息
    * </p>
*
* @author jimmy
* @since 2023-05-05
*/
@EqualsAndHashCode(callSuper = false)
@TableName("acc_business_account_extra")
public class BusinessAccountExtraDbo extends Dbo {
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
    * 省编码
    */
    @TableField("province_code")
    private String provinceCode;

    /**
    * 省名称
    */
    @TableField("province")
    private String province;

    /**
    * 市编码
    */
    @TableField("city_code")
    private String cityCode;

    /**
    * 市名称
    */
    @TableField("city")
    private String city;

    /**
    * 区编码
    */
    @TableField("district_code")
    private String districtCode;

    /**
    * 区名称
    */
    @TableField("district")
    private String district;

    /**
    * 头像
    */
    @TableField("avatar")
    private String avatar;

    /**
    * 详细地址
    */
    @TableField("addr_detail")
    private String addrDetail;

    /**
    * 签名
    */
    @TableField("signature")
    private String signature;

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
