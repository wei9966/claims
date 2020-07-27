package com.dm.claims.controller;

import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dm.claims.InsuranceClaimsForm;
import com.dm.claims.entity.*;
import com.dm.claims.feign.CarInsurFeign;
import com.dm.claims.feign.FormFeign;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.R;
import com.dm.claims.service.ImgService;
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
    @Autowired
    private ImgService imgService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        System.out.println("par"+params);
        PageUtils page = formService.queryPage(params);
        System.out.println(page.getList());
        Map<String,Object> pa=new HashMap<>();
        PageUtils imgPage = imgService.queryPage(pa);
        System.out.println(imgPage.getList());
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < imgPage.getList().size(); i++) {
            ImgEntity imgEntity= (ImgEntity) imgPage.getList().get(i);
            list.add(imgEntity.getClaimFormId());
        }
        for (int i = 0; i < page.getList().size(); i++) {
            FormEntity formEntity= (FormEntity) page.getList().get(i);
            List<ImgEntity> uriList=new ArrayList<>();
            if (list.contains(formEntity.getClaimFormId())){
                for (int j = 0; j < imgPage.getList().size(); j++) {
                    ImgEntity imgEntity= (ImgEntity) imgPage.getList().get(j);
                    if (imgEntity.getClaimFormId()==formEntity.getClaimFormId()){
                        uriList.add(imgEntity);
                    }
                }
            }
            formEntity.setClaimImgs(uriList);
        }
        System.out.println("转换后的对象"+page.getList());
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{claimFormId}")
    public R info(@PathVariable("claimFormId") Integer claimFormId){
		FormEntity form = formService.getById(claimFormId);
        Map<String,Object> pa=new HashMap<>();
        PageUtils imgPage = imgService.queryPage(pa);
        List<String> uriImages=new ArrayList<>();
        for (int i = 0; i < imgPage.getList().size(); i++) {
            ImgEntity imgEntity= (ImgEntity) imgPage.getList().get(i);
            if (imgEntity.getClaimFormId()==claimFormId){
                uriImages.add(imgEntity.getClaimImgUri());
            }
        }
        form.setClaimFormPictures(uriImages);
        return R.ok().put("form", form);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FormEntity form){
//		formService.save(form);
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
//		formService.removeByIds(Arrays.asList(claimFormIds));
		formService.deleteByIds(Arrays.asList(claimFormIds));
        return R.ok();
    }
    @RequestMapping("/insertForm")
    public R insertForm(@RequestBody FormEntity claimForm){
        System.out.println("保存的form"+claimForm+"\t"+claimForm.getClaimFormPicture());
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
