package com.dm.claims.service.impl;

import com.dm.claims.dao.IndemnityDao;
import com.dm.claims.entity.IndemnityEntity;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.Query;
import com.dm.claims.service.IndemnityService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("indemnityService")
public class IndemnityServiceImpl extends ServiceImpl<IndemnityDao, IndemnityEntity> implements IndemnityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IndemnityEntity> page = this.page(
                new Query<IndemnityEntity>().getPage(params),
                new QueryWrapper<IndemnityEntity>()
        );

        return new PageUtils(page);
    }

}