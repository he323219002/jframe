package com.jframe.basic.account.gatewayimpl.database.dataobject;

import java.time.LocalDateTime;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/3 22:58
 * @Description: 主账号
 */
public class AccMainDO {

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
     * 身份证号（加密后）
     */
    private String idNumberCrypt;

    /**
     * 生日
     */
    private LocalDateTime birthDay;

    /**
     * 账号状态 todo:修改成枚举
     */
    private Integer status;
}
