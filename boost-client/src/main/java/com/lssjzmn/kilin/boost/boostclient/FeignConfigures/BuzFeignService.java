package com.lssjzmn.kilin.boost.boostclient.FeignConfigures;

import com.lssjzmn.kilin.boost.boostclient.bo.LoginRet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "boost-provider", fallback = BuzFeignFallBack.class)
public interface BuzFeignService {

    @RequestMapping(value = "/provider/buz/providerLoginRet", method = RequestMethod.GET)
    LoginRet provideLogin();

}
