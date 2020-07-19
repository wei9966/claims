package com.dm.claims.controller;

import java.util.Arrays;
import java.util.Map;

import com.dm.claims.entity.LossAssessmentEntity;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.R;
import com.dm.claims.service.LossAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 定损表loss_assessment
 *
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@RestController
@RequestMapping("generator/lossassessment")
public class LossAssessmentController {
    @Autowired
    private LossAssessmentService lossAssessmentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lossAssessmentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{clossAssessmentId}")
    public R info(@PathVariable("clossAssessmentId") Integer clossAssessmentId){
	    LossAssessmentEntity lossAssessment = lossAssessmentService.getById(clossAssessmentId);

        return R.ok().put("lossAssessment", lossAssessment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LossAssessmentEntity lossAssessment){
		lossAssessmentService.save(lossAssessment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LossAssessmentEntity lossAssessment){
		lossAssessmentService.updateById(lossAssessment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] clossAssessmentIds){
		lossAssessmentService.removeByIds(Arrays.asList(clossAssessmentIds));

        return R.ok();
    }

}
