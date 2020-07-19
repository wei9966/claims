package com.dm.claims.controller;

import java.util.Arrays;
import java.util.Map;

import com.dm.claims.entity.FormEntity;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dm.claims.service.FormService;



/**
 * 理赔表claims_form
 *
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@RestController
@RequestMapping("claim/form")
public class FormController {
    @Autowired
    private FormService formService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = formService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{claimFormId}")
    public R info(@PathVariable("claimFormId") Integer claimFormId){
		FormEntity form = formService.getById(claimFormId);

        return R.ok().put("form", form);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FormEntity form){
		formService.save(form);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FormEntity form){
		formService.updateById(form);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] claimFormIds){
		formService.removeByIds(Arrays.asList(claimFormIds));

        return R.ok();
    }

}
