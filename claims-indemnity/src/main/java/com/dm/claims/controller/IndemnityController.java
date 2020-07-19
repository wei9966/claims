package com.dm.claims.controller;

import java.util.Arrays;
import java.util.Map;

import com.dm.claims.entity.IndemnityEntity;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.R;
import com.dm.claims.service.IndemnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 赔款表indemnity
 *
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@RestController
@RequestMapping("claim/indemnity")
public class IndemnityController {
    @Autowired
    private IndemnityService indemnityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = indemnityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{indemnityId}")
    public R info(@PathVariable("indemnityId") Integer indemnityId){
		IndemnityEntity indemnity = indemnityService.getById(indemnityId);

        return R.ok().put("indemnity", indemnity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody IndemnityEntity indemnity){
		indemnityService.save(indemnity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody IndemnityEntity indemnity){
		indemnityService.updateById(indemnity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] indemnityIds){
		indemnityService.removeByIds(Arrays.asList(indemnityIds));

        return R.ok();
    }

}
