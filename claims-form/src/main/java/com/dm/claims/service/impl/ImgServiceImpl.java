package com.dm.claims.service.impl;

import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dm.claims.dao.ImgDao;
import com.dm.claims.entity.ImgEntity;
import com.dm.claims.service.ImgService;


@Service("imgService")
public class ImgServiceImpl extends ServiceImpl<ImgDao, ImgEntity> implements ImgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ImgEntity> page = this.page(
                new Query<ImgEntity>().getPage(params),
                new QueryWrapper<ImgEntity>()
        );

        return new PageUtils(page);
    }

}