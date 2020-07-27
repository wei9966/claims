package com.dm.claims.service.impl;

import com.dm.claims.InsuranceClaimsForm;
import com.dm.claims.dao.ClaimImgDao;
import com.dm.claims.dao.FormDao;
import com.dm.claims.entity.FormEntity;
import com.dm.claims.entity.ImgEntity;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.Query;
import com.dm.claims.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;


@Service("formService")
public class FormServiceImpl extends ServiceImpl<FormDao, FormEntity> implements FormService {

    @Resource
    private ClaimImgDao claimImgDao;



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FormEntity> page=this.page(
                new Query<FormEntity>().getPage(params),
                new QueryWrapper<FormEntity>()
        );

          return new PageUtils(page);
    }

    @Override
    public FormEntity insert(FormEntity claimForm) {
        //添加之后返回一个主键
        this.baseMapper.insertForm(claimForm);
        //然后调用img dao 把图片存进去
        for (int i = 0; i < claimForm.getClaimFormPictures().size(); i++) {
            List<ImgEntity> imgEntity= claimImgDao.queryByUri(claimForm.getClaimFormPictures().get(i));
            if (imgEntity.size()==0) {
                //如果查不到才添加
                claimImgDao.insertListImgs(claimForm.getClaimFormPictures().get(i), claimForm.getClaimFormId());
            }
        }
        return claimForm;
    }

    @Override
    public FormEntity update(FormEntity claimForm) {
        this.baseMapper.updateForm(claimForm);
        for (int i = 0; i < claimForm.getClaimFormPictures().size(); i++) {
            List<ImgEntity> imgEntity= claimImgDao.queryByUri(claimForm.getClaimFormPictures().get(i));
            if (imgEntity.size()==0){
                //如果查不到才添加
                claimImgDao.insertListImgs(claimForm.getClaimFormPictures().get(i),claimForm.getClaimFormId());
            }
        }
        return claimForm;
    }

    @Override
    public void deleteByIds(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            claimImgDao.deleteByFormId(list.get(i));
        }
        this.baseMapper.deleteBatchIds(list);
    }
}