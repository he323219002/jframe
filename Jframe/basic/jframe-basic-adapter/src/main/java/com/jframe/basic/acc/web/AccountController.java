package com.jframe.basic.acc.web;

import com.jframe.basic.acc.api.AccountService;
import com.jframe.basic.acc.dto.AccountTestQry;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/acc/user/test")
    public String testUser(@Valid AccountTestQry qry){
        return accountService.testGet(qry);
    }
}
