package com.jframe.basic.acc.web;

import com.jframe.base.CommonResult;
import com.jframe.basic.acc.api.AccountService;
import com.jframe.basic.acc.dto.AccountTestQry;
import com.jframe.basic.acc.dto.cmd.AccountAdminCreateCmd;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/5 19:14
 * @Description: 账号接口
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping(value = "/new_acc/user/test")
    public String testUser(@Valid AccountTestQry qry) {
        System.out.println("123");
        return accountService.testGet(qry);
    }

    @PostMapping(value = "/acc/user/admin_creat")
    public CommonResult<Void> createAdmin(@Valid @RequestBody AccountAdminCreateCmd cmd) {
        accountService.createAdmin(cmd);
        return CommonResult.success(null);
    }
}
