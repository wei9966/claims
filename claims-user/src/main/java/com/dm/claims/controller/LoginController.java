package com.dm.claims.controller;

import java.util.Arrays;
import java.util.Map;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.druid.sql.visitor.functions.If;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dm.claims.entity.LoginEntity;
import com.dm.claims.service.LoginService;



/**
 * 
 *
 * @author wb
 * @email 996649855@qq.com
 * @date 2020-07-26 14:14:00
 */
@RestController
@RequestMapping("claim/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    MD5 md5=new MD5();
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = loginService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{insuranceLoginId}")
    public R info(@PathVariable("insuranceLoginId") Integer insuranceLoginId){
		LoginEntity login = loginService.getById(insuranceLoginId);
        return R.ok().put("login", login);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LoginEntity login){
        login.setInsuranceLoginPassword(md5.digestHex(login.getInsuranceLoginPassword()));
        int i = loginService.insertLoginEntity(login);
        if (i==0){
            return  R.error();
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LoginEntity login){
        login.setInsuranceLoginPassword(md5.digestHex(login.getInsuranceLoginPassword()));
        int i = loginService.updateLoginEntity(login);
        if (i==0){
            return  R.error();
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] insuranceLoginIds){
		loginService.removeByIds(Arrays.asList(insuranceLoginIds));
        return R.ok();
    }

}
