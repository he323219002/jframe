package com.jframe.basic.org.web;

import com.jframe.basic.acc.dto.AccountTestQry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Jimmy He
 * @date 2023/08/04
 * @description: 组织接口
 */
@RestController
public class OrgController {

    @GetMapping(value = "/org/test")
    public String testUser(@Valid AccountTestQry qry) {
        System.out.println("123");
        return "123";
    }
}
