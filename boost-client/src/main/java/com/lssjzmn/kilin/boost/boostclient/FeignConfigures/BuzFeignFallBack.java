package com.lssjzmn.kilin.boost.boostclient.FeignConfigures;

import com.lssjzmn.kilin.boost.boostclient.bo.LoginRet;

public class BuzFeignFallBack implements BuzFeignService {
    @Override
    public LoginRet provideLogin() {
        return new LoginRet();
    }
}
