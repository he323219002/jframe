package com.jframe.basic.acc.web;

import com.jframe.base.CommonResult;
import com.jframe.basic.acc.api.BusinessAccountService;
import com.jframe.basic.acc.dto.cmd.BusinessAccountLoginCmd;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author: Jimmy He
 * @Date: 2024/3/23 14:45
 * @Description: 业务账号登录
 */
@RestController
public class BusinessAccountController {

    @Resource
    private BusinessAccountService businessAccountService;

    /**
     * 业务账号登录
     * @param cmd
     * @return
     */
    @PostMapping("/acc/biz_account/login")
    public CommonResult<Void> login(@Valid @RequestBody BusinessAccountLoginCmd cmd) {
        businessAccountService.login(cmd);
        return CommonResult.success(null);
    }


}
