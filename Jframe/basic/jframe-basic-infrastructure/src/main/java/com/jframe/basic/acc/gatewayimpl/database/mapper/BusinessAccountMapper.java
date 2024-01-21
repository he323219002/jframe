package com.jframe.basic.acc.gatewayimpl.database.mapper;

import com.jframe.basic.acc.gatewayimpl.database.dataobject.BusinessAccountDbo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 业务账号 Mapper 接口
 * </p>
 *
 * @author jimmy
 * @since 2024-01-21
 */
@Mapper
public interface BusinessAccountMapper extends BaseMapper<BusinessAccountDbo> {

}
