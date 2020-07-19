package com.dm.claims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dm.claims.entity.IndemnityEntity;
import com.dm.claims.pojo.PageUtils;

import java.util.Map;

/**
 * 赔款表indemnity
 *
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
public interface IndemnityService extends IService<IndemnityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

