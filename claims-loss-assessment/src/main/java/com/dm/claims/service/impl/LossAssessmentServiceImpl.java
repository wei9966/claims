package com.dm.claims.service.impl;

import com.dm.claims.dao.LossAssessmentDao;
import com.dm.claims.entity.LossAssessmentEntity;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.Query;
import com.dm.claims.service.LossAssessmentService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("lossAssessmentService")
public class LossAssessmentServiceImpl extends ServiceImpl<LossAssessmentDao, LossAssessmentEntity> implements LossAssessmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LossAssessmentEntity> page = this.page(
                new Query<LossAssessmentEntity>().getPage(params),
                new QueryWrapper<LossAssessmentEntity>()
        );

        return new PageUtils(page);
    }

}