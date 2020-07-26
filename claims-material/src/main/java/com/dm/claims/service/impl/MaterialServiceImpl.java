package com.dm.claims.service.impl;

import com.dm.claims.dao.MaterialDao;
import com.dm.claims.entity.MaterialEntity;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.Query;
import com.dm.claims.service.MaterialService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("materialService")
public class MaterialServiceImpl extends ServiceImpl<MaterialDao, MaterialEntity> implements MaterialService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialEntity> page = this.page(
                new Query<MaterialEntity>().getPage(params),
                new QueryWrapper<MaterialEntity>()
        );

        return new PageUtils(page);
    }

}