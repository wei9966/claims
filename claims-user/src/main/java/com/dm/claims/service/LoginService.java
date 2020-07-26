package com.dm.claims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dm.claims.entity.LoginEntity;
import com.dm.claims.pojo.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author wb
 * @email 996649855@qq.com
 * @date 2020-07-26 14:14:00
 */
public interface LoginService extends IService<LoginEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 增加登录用户
     * @param loginEntity 实体类
     * @return 是否新增成功
     */
    int insertLoginEntity(LoginEntity loginEntity);

    /**
     * 修改登录用户
     * @param loginEntity 实体类
     * @return 是否修改成功
     */
    int updateLoginEntity(LoginEntity loginEntity);
}

