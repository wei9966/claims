package com.dm.claims.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dm.claims.entity.IndemnityEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 赔款表indemnity
 * 
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@Mapper
public interface IndemnityDao extends BaseMapper<IndemnityEntity> {
	
}
