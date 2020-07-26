package com.dm.claims.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.dm.claims.pojo.PageUtils;
import com.dm.claims.pojo.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dm.claims.dao.LoginDao;
import com.dm.claims.entity.LoginEntity;
import com.dm.claims.service.LoginService;


/**
 * @author WB
 */
@Service("loginService")
public class LoginServiceImpl extends ServiceImpl<LoginDao, LoginEntity> implements LoginService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LoginEntity> page = this.page(
                new Query<LoginEntity>().getPage(params),
                new QueryWrapper<LoginEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int insertLoginEntity(LoginEntity loginEntity) {
        List<LoginEntity> repeatEmailOrPhoneOrName = this.baseMapper.isRepeatEmailOrPhoneOrName(loginEntity.getInsuranceLoginUser(), loginEntity.getInsuranceLoginPhone(), loginEntity.getInsuranceLoginEmai());
        if ((repeatEmailOrPhoneOrName.size()==0)){
            this.baseMapper.insert(loginEntity);
            return  1;
        }
        return 0;
    }

    @Override
    public int updateLoginEntity(LoginEntity loginEntity) {
        List<LoginEntity> repeatEmailOrPhoneOrName = this.baseMapper.isRepeatEmailOrPhoneOrName(loginEntity.getInsuranceLoginUser(), loginEntity.getInsuranceLoginPhone(), loginEntity.getInsuranceLoginEmai());
        System.out.println("大小"+repeatEmailOrPhoneOrName.size());
        if ((repeatEmailOrPhoneOrName.size()<=1)){
            this.baseMapper.updateById(loginEntity);
            return  1;
        }
        return 0;
    }

}