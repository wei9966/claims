package com.dm.claims.feign;

import com.dm.claims.entity.InsuranceCarInsur;
import com.dm.claims.entity.InsuranceInserInclude;
import com.dm.claims.pojo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "insurance-car-insur")
public interface CarInsurFeign {

    @RequestMapping("/carInsur/incloud/selectOne")
    public InsuranceInserInclude selectOne(@RequestParam("id")Integer id);

    @GetMapping("/carInsur/insur/selectAllType")
    public R queryAllType(@RequestParam("ciType") String ciType,
                          @RequestParam("ciState") Integer ciState) ;

    @RequestMapping("/carInsur/insur/selectOne")
    public InsuranceCarInsur selectCarInsur(@RequestParam("id") Integer id);
}
