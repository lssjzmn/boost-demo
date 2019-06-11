package com.lssjzmn.kilin.boost.boostclient.controller;

import com.lssjzmn.kilin.boost.boostclient.FeignConfigures.BuzFeignService;
import com.lssjzmn.kilin.boost.boostclient.bo.LoginRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@Slf4j
@RestController
@RequestMapping(value = "/client/buz")
public class BuzController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BuzFeignService buzFeignService;

    @RequestMapping(value = "/requestLoginRet", method = RequestMethod.GET)
    public Object requestLogin() {
        //log.info("requestLogin...");
        //ResponseEntity<LoginRet> responseEntity = restTemplate.getForEntity("boost-provider/provideLoginRet.html", LoginRet.class);
        LoginRet loginRet = buzFeignService.provideLogin();
        return loginRet;
    }
}
