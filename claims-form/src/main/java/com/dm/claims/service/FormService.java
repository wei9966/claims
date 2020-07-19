package com.dm.claims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dm.claims.entity.FormEntity;
import com.dm.claims.pojo.PageUtils;

import java.util.Map;

/**
 * 理赔表claims_form
 *
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
public interface FormService extends IService<FormEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

