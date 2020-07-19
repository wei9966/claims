package com.dm.claims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dm.claims.entity.LossAssessmentEntity;
import com.dm.claims.pojo.PageUtils;

import java.util.Map;

/**
 * 定损表loss_assessment
 *
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
public interface LossAssessmentService extends IService<LossAssessmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

