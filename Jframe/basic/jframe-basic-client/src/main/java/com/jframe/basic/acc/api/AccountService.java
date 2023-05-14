package com.jframe.basic.acc.api;


import com.jframe.basic.acc.dto.AccountTestQry;

/**
 * <p>
 * 账号 服务类
 * </p>
 *
 * @author jimmy
 * @since 2023-04-27
 */
public interface AccountService {

    String testGet(AccountTestQry qry);
}
