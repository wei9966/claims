package com.dm.claims.dao;

import com.dm.claims.entity.LoginEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author wb
 * @email 996649855@qq.com
 * @date 2020-07-26 14:14:00
 */
@Mapper
public interface LoginDao extends BaseMapper<LoginEntity> {

    public List<LoginEntity> isRepeatEmailOrPhoneOrName(@Param("insuranceLoginUser") String name, @Param("insuranceLoginPhone") String email, @Param("insuranceLoginEmai") String phone);
}
