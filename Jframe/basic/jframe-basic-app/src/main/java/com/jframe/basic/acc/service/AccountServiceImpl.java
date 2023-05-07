package com.jframe.basic.acc.service;

import com.jframe.basic.acc.gatewayimpl.database.dataobject.AccountDbo;
import com.jframe.basic.acc.gatewayimpl.database.mapper.AccountMapper;
import com.jframe.basic.acc.api.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号 服务实现类
 * </p>
 *
 * @author jimmy
 * @since 2023-04-27
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountDbo> implements AccountService {

}
