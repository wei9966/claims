package com.dm.claims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dm.claims.InsuranceClaimsForm;
import com.dm.claims.entity.FormEntity;
import com.dm.claims.pojo.PageUtils;

import java.util.List;
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

    FormEntity insert(FormEntity claimForm);

    FormEntity update(FormEntity claimForm);

    /**
     * 批量删除
     * @param list
     */
    void deleteByIds(List<Integer> list);
}

