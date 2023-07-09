package com.jframe.basic.per.gatewayimpl.database.mapper;

import com.jframe.basic.per.gatewayimpl.database.dataobject.RoleDbo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author jimmy
 * @since 2023-07-09
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleDbo> {

}
