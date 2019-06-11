package com.lssjzmn.kilin.boost.facility;

import com.lssjzmn.kilin.boost.bo.dataverify.VerifyResult;
import com.lssjzmn.kilin.boost.bo.dataverify.VerifyTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DataVerifyCache extends BaseCache<VerifyTarget, VerifyResult> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected VerifyResult loadData(VerifyTarget verifyTarget) {
        //logger.info("DataVerifyCache start load data of :" + verifyTarget.getTargetName());
        DataVerifyWorker verifyWorker = new DataVerifyWorker();
        verifyWorker.setVerifyTarget(verifyTarget);
        return verifyWorker.doVerify();
    }

    @Override
    protected int maximumSize() {
        return 1000;
    }

    @Override
    protected int initialCapacity() {
        return 100;
    }

    @Override
    protected int durationOfSeconds() {
        return 1;
    }
}
