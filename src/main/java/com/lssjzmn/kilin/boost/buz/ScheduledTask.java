package com.lssjzmn.kilin.boost.buz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //cron、fixedDelay、fixedRate 三者之间不能共存！！！
    @Async("scheduledWorker")
    @Scheduled(fixedRate = 5 * 1000L, initialDelay = 8 * 1000L)
    public void scheduledWork() {
        logger.info("scheduledWork at " + System.currentTimeMillis());
    }
}
