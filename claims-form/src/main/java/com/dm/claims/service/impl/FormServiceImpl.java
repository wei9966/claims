package com.dm.claims.service.impl;

import com.dm.claims.dao.FormDao;
import com.dm.claims.entity.FormEntity;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.Query;
import com.dm.claims.service.FormService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("formService")
public class FormServiceImpl extends ServiceImpl<FormDao, FormEntity> implements FormService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FormEntity> page=this.page(
                new Query<FormEntity>().getPage(params),
                new QueryWrapper<FormEntity>()
        );
          return new PageUtils(page);
    }
}