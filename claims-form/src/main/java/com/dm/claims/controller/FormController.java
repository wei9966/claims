package com.dm.claims.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dm.claims.InsuranceClaimsForm;
import com.dm.claims.entity.FormEntity;
import com.dm.claims.entity.InsuranceCarInsur;
import com.dm.claims.entity.InsuranceInserInclude;
import com.dm.claims.entity.InsuranceInsurContract;
import com.dm.claims.feign.CarInsurFeign;
import com.dm.claims.feign.FormFeign;
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
    @Autowired
    private FormFeign formFeign;
    @Autowired
    private CarInsurFeign carInsurFeign;
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
    @RequestMapping("/insertForm")
    public R insertForm(@RequestBody FormEntity claimForm){
        InsuranceInsurContract userInfoByPhone = formFeign.getUserInfoByPhone(claimForm.getClaimFormExplorationPhone());
        if (userInfoByPhone!=null){
            claimForm.setInsuranceInserIncludeId(userInfoByPhone.getIpId());
        }
        FormEntity formEntity= formService.insert(claimForm);
       return R.ok().put("form",formEntity).put("contract",userInfoByPhone);
    }

    @RequestMapping("/selectContract")
    public InsuranceInsurContract getContract(String phone){
        System.out.println("电话号码是"+phone);
        return formFeign.getUserInfoByPhone(phone);
    }

    @RequestMapping("/updateForm")
    public R updateForm(@RequestBody FormEntity claimForm){
        InsuranceInsurContract userInfoByPhone = formFeign.getUserInfoByPhone(claimForm.getClaimFormExplorationPhone());
        if (userInfoByPhone!=null){
            claimForm.setInsuranceInserIncludeId(userInfoByPhone.getIpId());
        }
        FormEntity formEntity= formService.update(claimForm);
        return R.ok().put("form",formEntity).put("contract",userInfoByPhone);
    }

    @RequestMapping("/getInclude")
    public R getInsuranceInserIncludeOption(Integer id){
        InsuranceInserInclude insuranceInserInclude = carInsurFeign.selectOne(id);
        return  R.ok().put("include",insuranceInserInclude);
    }

    @RequestMapping("/getCarInsur")
    public R getInsuranceCarInsur(Integer id){
        InsuranceCarInsur insuranceCarInsur = carInsurFeign.selectCarInsur(id);
        return  R.ok().put("data",insuranceCarInsur);
    }
    @RequestMapping("/getAllTypeCarInsur")
    public R getInsuranceAllTypeCarInsur(@RequestParam("ciType") String ciType,
                                         @RequestParam("ciState") Integer ciState){
            R r = carInsurFeign.queryAllType(ciType, ciState);
//    //        JSON.parse(r.get("data").toString());
//            System.out.println("查询出来的数"+r.get("data").toString());
//    //        JSONArray data = JSONArray.parseArray(r.get("data").toString());
//        //讲JSON转换成JSON初级
//        JSONArray data = JSONObject.parseArray(JSON.toJSONString(r.get("data")));
//        Arrays.asList(data.toArray());
////            System.out.println("查询出来的数"+r.get("data")+"\t"+data);
            return  R.ok().put("data",r);
    }

    @RequestMapping("/getUserInfo")
    public R getUserInfo(String phone){
        return  R.ok().put("data",this.formFeign.getUserInfoByPhone(phone));
    }
}
