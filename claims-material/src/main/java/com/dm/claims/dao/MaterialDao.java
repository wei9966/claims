package com.dm.claims.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dm.claims.entity.MaterialEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 理赔资料表material
 * 
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@Mapper
public interface MaterialDao extends BaseMapper<MaterialEntity> {
	
}
