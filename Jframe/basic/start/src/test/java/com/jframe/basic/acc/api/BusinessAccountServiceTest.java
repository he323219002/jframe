package com.jframe.basic.acc.api;

import com.jframe.basic.Application;
import com.jframe.basic.acc.dto.cmd.BusinessAccountCreateCmd;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: Jimmy He
 * @Date: 2024/3/23 16:27
 * @Description: TODO 描述
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class BusinessAccountServiceTest {

    @Resource
    private BusinessAccountService businessAccountService;

    @Test
    void create() {
        BusinessAccountCreateCmd param = new BusinessAccountCreateCmd()
                .setPhone("1317890")
                .setUsername("test_biz_1")
                .setPassword("123456")
                .setBizType("OPERATION_PLATFORM");
        businessAccountService.create(param);
    }
}