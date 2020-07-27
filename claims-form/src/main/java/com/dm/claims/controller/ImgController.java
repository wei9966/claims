package com.dm.claims.controller;

import java.util.Arrays;
import java.util.Map;

import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dm.claims.entity.ImgEntity;
import com.dm.claims.service.ImgService;



/**
 * 
 *
 * @author wb
 * @email 996649855@qq.com
 * @date 2020-07-27 16:18:34
 */
@RestController
@RequestMapping("claim/form/img")
public class ImgController {
    @Autowired
    private ImgService imgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        System.out.println("ppp"+params);
        PageUtils page = imgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{claimImgId}")
    public R info(@PathVariable("claimImgId") Integer claimImgId){
		ImgEntity img = imgService.getById(claimImgId);

        return R.ok().put("img", img);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ImgEntity img){
		imgService.save(img);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ImgEntity img){
		imgService.updateById(img);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] claimImgIds){
		imgService.removeByIds(Arrays.asList(claimImgIds));

        return R.ok();
    }

}
