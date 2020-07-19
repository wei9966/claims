package com.dm.claims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dm.claims.entity.MaterialEntity;
import com.dm.claims.pojo.PageUtils;

import java.util.Map;

/**
 * 理赔资料表material
 *
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
public interface MaterialService extends IService<MaterialEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

