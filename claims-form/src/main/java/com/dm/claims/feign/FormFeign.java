package com.dm.claims.feign;

import com.dm.claims.entity.InsuranceInsurContract;
import com.dm.claims.pojo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "insurance-city")
public interface FormFeign {

    @RequestMapping("/insuranceCity/insuranceUserInfo/infoByPhone")
    public InsuranceInsurContract getUserInfoByPhone(@RequestParam("phone") String phone);


}
