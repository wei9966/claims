package com.dm.claims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dm.claims.entity.ImgEntity;
import com.dm.claims.pojo.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author wb
 * @email 996649855@qq.com
 * @date 2020-07-27 16:18:34
 */
public interface ImgService extends IService<ImgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

