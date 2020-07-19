package com.dm.claims.dao;

import com.dm.claims.entity.FormEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 理赔表claims_form
 * 
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@Mapper
public interface FormDao extends BaseMapper<FormEntity> {
	
}
