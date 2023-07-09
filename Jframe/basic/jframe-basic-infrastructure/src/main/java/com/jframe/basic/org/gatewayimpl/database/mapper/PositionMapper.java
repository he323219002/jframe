package com.jframe.basic.org.gatewayimpl.database.mapper;

import com.jframe.basic.org.gatewayimpl.database.dataobject.PositionDbo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 职位表 Mapper 接口
 * </p>
 *
 * @author jimmy
 * @since 2023-07-09
 */
@Mapper
public interface PositionMapper extends BaseMapper<PositionDbo> {

}
