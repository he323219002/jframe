package com.jframe.basic.acc.gatewayimpl.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jframe.basic.acc.domain.enumerate.BusinessAccountTypeEnum;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.AccountDbo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账号 Mapper 接口
 * </p>
 *
 * @author jimmy
 * @since 2023-04-26
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountDbo> {

}
