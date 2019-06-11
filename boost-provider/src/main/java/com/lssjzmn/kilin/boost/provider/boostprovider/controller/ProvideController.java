package com.lssjzmn.kilin.boost.provider.boostprovider.controller;

import com.lssjzmn.kilin.boost.provider.boostprovider.bo.LoginRet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/provider/buz")
public class ProvideController {

    @RequestMapping(value = "/providerLoginRet", method = RequestMethod.GET)
    public Object provideLogin() {
        log.info("provideLogin...");
        LoginRet loginRet = new LoginRet();
        loginRet.setId(10000L);
        loginRet.setStatus("200 OK");
        loginRet.setInfo("provide success.");
        loginRet.getBody().put("provideInfo", 10001);
        return loginRet;
    }
}
